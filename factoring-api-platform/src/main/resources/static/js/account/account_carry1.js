function getDrawCash() {
	var cardNo = $("#bankNo").val();
	if (!cardNo) {
		Dialog.alertWarn("请先绑定银行卡!");
		return;
	}
	
	var score = $("#score").val();
	var balance = $("#balance").text();
    var payPassword = $("#payPassword").val();

	if (!score) {
		Dialog.alertWarn("金额不能为空!");
		return;
	}

    if (!payPassword){
        Dialog.alertWarn("支付密码不能为空!");
        return;
    }

	if (score > parseFloat(balance)) {
		Dialog.alertWarn("店铺余额不足!");
		return;
	}

	// if (!Dialog.isInteger(score)) {
	// 	Dialog.alertWarn("请输入整数金额!");
	// 	return;
	// }

	var cardId = $("#cardId").val();
	var bankName = $("#bankName").val();

	var params = {
		money : score,
		cardId : cardId,
        payPassword : md5(payPassword)
	};

	var userId = $("#userId").val();

	var url = "/web/cashmoney/withDrawals";
	$.post(url, params, function(data, textStatus, req) {
		if (data.code == 150016) {
			//跳转到账户余额页面
            layer.alert(data.message, {
                icon: 1,
                closeBtn: 0,
                btnAlign: 'c'
            }, function () {
                location.href = "/web/member/tomerchantIdUserMoneyPage";
            })
		}

		if (data.code != 150016) {
            layer.alert(data.message, {
                icon: 2,
                closeBtn: 0,
                btnAlign: 'c'
            }, function () {
                window.history.go(-1);
            })
		}
	}, 'json')
}