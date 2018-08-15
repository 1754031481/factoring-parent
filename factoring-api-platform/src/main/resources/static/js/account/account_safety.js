function savePwd() {
	var type = $("#type").val();
    var pwdTest = /^\d{6}$/;
	if(!type) {
		Dialog.alertWarn("系统繁忙,请联系开发人员");
		return;
	}
	
	var newPwd = $("#newPwd").val();
	var newPwd1 = md5(newPwd);
    if (type == 1){

        if(newPwd.length < 6 ||　newPwd.length > 20) {
            Dialog.alertWarn("密码应该在6~20个字符之间!");
            return;
        }
    } else if (type == 2) {
        if(!pwdTest.test(newPwd)) {
            Dialog.alertWarn("支付密码应为6位纯数字!");
            return;
        }
    }
	$("input[name='newPwd']").val(newPwd1);

	var confirmPwd = $("#confirmPwd").val();
	var fromHtml = $("#fromHtml").val();
	var confirmPwd1=md5(confirmPwd);
	$("input[name='confirmPwd']").val(confirmPwd1);

	if(!newPwd) {
		Dialog.alertWarn("请输入密码!");
		return;
	}

	if(!confirmPwd) {
		Dialog.alertWarn("请再输入密码!");
		return;
	}
	if(newPwd1 != confirmPwd1) {
		Dialog.alertWarn("两次输入密码不一致!");
		return;
	}
	
	var smsCode = $("#smsCode").val();
	if(!smsCode) {
		Dialog.alertWarn("请输入验证码!");
		return;
	}
	var params = $("#pwdForm").serializeJson();
	if(params.type == 1) {
		$.post("/web/safemanage/updateloginpwd",params,function(data){
			if(data.code == 200) {
				Dialog.toLogin("操作成功,请重新登录");
				Dialog.clearData("pwdForm");
			} else {
				Dialog.alertWarn(data.message);
				$("input[name='newPwd']").val("");
				$("input[name='confirmPwd']").val("");
				$("input[name='smsCode']").val("");
			}
			
		},'json');
	} else if(params.type == 2) {
		$.post("/web/safemanage/updatepaypwd",params,function(data){
			if(data.code == 200) {
				Dialog.alertInfo("修改支付密码成功");
                if (fromHtml == 1){
                    window.location.href = "/web/useraccountmanager/todrawcash1";
                    // window.history.back(-1);
                }
                if (fromHtml == 2){
					var dataStr = sessionStorage.getItem("dataUrl");
                    location.href = dataStr;
                }
                if (fromHtml == 3){
                    location.href = "/web/useraccountmanager/todrawcash";
                }
                Dialog.clearData("pwdForm");
			} else {
			    Dialog.alertWarn(data.message);
			}
		},'json');
	} else {
		Dialog.alertError("系统内部错误，请联系开发人员!");
		return;
	}
//	
//	alert(JSON.stringify(params));
}

function setLoginType() {
    // $("#pwdForm input").each(function(){
    //     if($(this).attr('type')!="button"){
    //         $(this).val('');
    //     }
    // });
    $("#newPwd").val("");
    $("#confirmPwd").val("");
    $("#smsCode").val("");
    $("#type").val(1);
}

function setPayType() {
    // $("#pwdForm input").each(function(){
    // 	if($(this).attr('type')!="button"){
    //         $(this).val('');
		// }
    //
    // });
    $("#newPwd").val("");
    $("#confirmPwd").val("");
    $("#smsCode").val("");
	$("#type").val(2);
}

//获取验证码
function getSmsCode() {
	var newPwd = $("#newPwd").val();
	var confirmPwd = $("#confirmPwd").val();
	var type = $("#type").val();
    var pwdTest = /^\d{6}$/;
	if(!newPwd) {
		Dialog.alertWarn("请输入密码!");
		return;
	}
	if (type == 1){

        if(newPwd.length < 6 ||　newPwd.length > 20) {
            Dialog.alertWarn("密码应该在6~20个字符之间!");
            return;
        }
    } else if (type == 2) {
        if(!pwdTest.test(newPwd)) {
            Dialog.alertWarn("支付密码应为6位纯数字!");
            return;
        }
	}
	if(!confirmPwd) {
		Dialog.alertWarn("请再输入密码!");
		return;
	}
	if(newPwd != confirmPwd) {
		Dialog.alertWarn("两次输入密码不一致!");
		return;
	}
	ReadTime.readTime("smsId");
	var codeType = "ty_password";
	var data = {"phone":$("#telPhone").val(),"codeType":codeType};
	$.post("/web/sms/findPassword", data, function(data) {
			Dialog.alertWarn(data.message);
	}, 'json');
}