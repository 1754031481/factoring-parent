
/**
 * 模块数量
 * @type {number}
 */
var moduleCount=0;
var defaults = {
    fileType: ["jpg", "png", "bmp", "jpeg", "JPG", "PNG", "JPEG", "BMP"], // 上传文件的类型
    fileSize: 1024 * 1024 * 5,// 上传文件的大小 5M
    count: 0
    // 计数器
};
/**
 * 当前操作模块ID
 */
var currentId=0;
$(function () {
    //点击任意取消模块工具栏
    $(document).click(function(){
        $(".module").removeClass("mobileCurrent");
    });
    //点击模块
    $(document).on("click",'.module', function (event) {
        event.stopPropagation();
        $(".module").removeClass("mobileCurrent");
        $(this).addClass("mobileCurrent");
    });
    //添加文字
    $(document).on("click",'.add-btn .text', function () {
        $(".edit-area").show();
        toPanelBottom();
    });
    //添加图片
    $(document).on("click",'.add-btn .image', function () {
        $("#mobileFile").click();
    });
    //添加商品
    $(document).on("click",'.add-btn .product', function () {
        showProduct();
    });
    //添加音频
    $(document).on("click",'.add-btn .audio', function () {
        $("#audioFile").click();
    });
    //添加视频
    $(document).on("click",'.add-btn .video', function () {
        $("#videoFile").click();
    });
    //文字提交
    $(document).on("click",'.text-submit', function () {
        var text_edit=$("#text-edit");
        if(!text_edit.val()){
            layer.alert("请输入文字", {icon: 2,title: '提示',closeBtn: 0,btnAlign: 'c'});
            return false;
        }
        if(text_edit.val().length>5000){
            layer.alert("文字不能超过5000字", {icon: 2,title: '提示',closeBtn: 0,btnAlign: 'c'});
            return false;
        }
        if(currentId==0){
            addModule(0,text_edit.val());
            text_edit.val("");
            $(".edit-area").hide();
        }else{
            var text_html = $("#"+currentId).find(".text-html");
            text_html.text(text_edit.val());
            $(".edit-area").hide();
            currentId=0;
        }
    });
    //文字取消
    $(document).on("click",'.text-cancel', function () {
        $(".edit-area").hide();
        $("#text-edit").val("");
    });

    //编辑
    $(document).on("click",'.edit', function () {
        updateText(this);
    });
    //删除
    $(document).on("click",'.delete', function () {
        var module = $(this).parents(".module");
        module.remove();
        moduleCount--;
        var i = 1;
        $.each($(".module"),function(){
            $(this).attr("id",i);
            i++;
        });
    });
    //上传图片
    $(document).on("change",'#mobileFile', function () {
        uploadMobileImg("mobileFile");
    });
    //上传音频
    $(document).on("change",'#audioFile', function () {
        uploadMobileAudio("audioFile");
    });
    //上传视频
    $(document).on("change",'#videoFile', function () {
        uploadMobileVideo("videoFile");
    });
});
/**
 * 添加模块
 * @param type  类型：0文字 1图片 2商品
 * @param detail   详情
 */
var addModule = function (type,detail) {
    $(".module").removeClass("end");
    var cp=$(".control-panel");
    moduleCount++;
    var module=document.createElement("div");
    //添加tools
    var tools = document.createElement("ul");
    tools.className="tools";
    var moduleName = "";
    if(type==0){
        var update = document.createElement("li");
        var update_a = document.createElement("a");
        update_a.href="#";
        update_a.className="edit";
        update_a.innerHTML="编辑";
        update.appendChild(update_a);
        tools.appendChild(update);
        moduleName = "m-text";
    }else if(type==1){
        moduleName = "m-image";
    }else if(type==2){
        var product = document.createElement("li");
        var product_a = document.createElement("a");
        product_a.href="#";
        product_a.className="product";
        product_a.innerHTML="商品";
        product.appendChild(product_a);
        tools.appendChild(product);
        moduleName = "m-product";
    }else if(type==3){
        var audio = document.createElement("li");
        var audio_a = document.createElement("a");
        audio_a.href="#";
        audio_a.className="audio";
        audio_a.innerHTML="音频";
        audio.appendChild(audio_a);
        tools.appendChild(audio);
        moduleName = "m-voice";
    }else{
        var video = document.createElement("li");
        var video_a = document.createElement("a");
        video_a.href="#";
        video_a.className="video";
        video_a.innerHTML="视频";
        video.appendChild(video_a);
        tools.appendChild(video);
        moduleName = "m-video";
    }
    module.className="module "+moduleName+" end";
    module.id=moduleCount;
    var del = document.createElement("li");
    var del_a = document.createElement("a");
    del_a.href="#";
    del_a.className="delete";
    del_a.innerHTML="删除";
    del.appendChild(del_a);
    tools.appendChild(del_a);
    module.appendChild(tools);
    //添加cover
    var cover = document.createElement("div");
    cover.className="cover";
    module.appendChild(cover);
    //添加content
    var content = document.createElement("div");
    content.className="content";
    var obj_div;
    if(type==0){
        //文字
        obj_div = document.createElement("div");
        obj_div.className="text-div";
        var text_html = document.createElement("div");
        text_html.className="text-html J_Html";
        text_html.innerHTML=detail;
        obj_div.appendChild(text_html);
    }else if(type==1){
        //图片
        obj_div = document.createElement("div");
        obj_div.className="image-div";
        var img = document.createElement("img");
        img.src=detail;
        obj_div.appendChild(img);
    }else if(type==2){
        //商品
        var str = detail.split(",");
        var productId = str[0];
        var imgUrl = str[1];
        //图片
        obj_div = document.createElement("div");
        obj_div.className="product-div";
        var img = document.createElement("img");
        img.src=imgUrl;
        img.alt=productId;
        obj_div.appendChild(img);
    }else if(type==3){
        //音频
        obj_div = document.createElement("div");
        obj_div.className="audio-div";
        var i = document.createElement("i")
        i.className="glyphicon glyphicon-music audio-icon";
        var audio_title_div = document.createElement("div");
        audio_title_div.className="audio-title";
        audio_title_div.innerHTML=detail.address;
        var audio_size_div = document.createElement("div");
        audio_size_div.className="audio-size";
        audio_size_div.innerHTML=detail.size+"M";
        obj_div.appendChild(i);
        obj_div.appendChild(audio_title_div);
        obj_div.appendChild(audio_size_div);
    }else{
        //视频
        obj_div = document.createElement("div");
        obj_div.className="video-div";
        var video = document.createElement("video");
        video.src=detail;
        video.style="max-width: 290px;";
        obj_div.appendChild(video);
    }
    content.appendChild(obj_div);
    module.appendChild(content);
    cp.append(module);
    if(type==1){
        setTimeout("toPanelBottom()",1000);
    }else{
        toPanelBottom();
    }
}
/**
 * 编辑文字
 */
var updateText = function (e) {
    var module=$(e).parents(".module");
    var id = module.attr("id");
    currentId=id;
    var text_html = module.find(".text-html");
    var text_edit=$("#text-edit");
    text_edit.val(text_html.text());
    $(".edit-area").show();
    toPanelBottom();
}
/**
 * 滚动到底部
 */
var toPanelBottom = function () {
    var content_edit = $(".content-edit");
    content_edit.scrollTop(content_edit[0].scrollHeight);
}

function validateUp(files,num) {
    var arrFiles = [];//替换的文件数组
    for (var i = 0, file; file = files[i]; i++) {
        //获取文件上传的后缀名
        var newStr = file.name.split("").reverse().join("");
        if (newStr.split(".")[0] != null) {
            var type = newStr.split(".")[0].split("").reverse().join("");

            if (jQuery.inArray(type, defaults.fileType) > -1) {
                // 类型符合，可以上传
                if (file.size >= defaults.fileSize) {
                    layer.msg(file.name + '文件过大',{
                        type: 1,
                        title: '警告',
                        closeBtn : 0,
                        btn:['确定'],
                        btnAlign: 'c'
                    });
                } else {
                    // 在这里需要判断当前所有文件中
                    arrFiles.push(file);
                }
            } else {
                layer.msg(file.name + '上传类型不符合',{
                    type: 1,
                    title: '警告',
                    closeBtn : 0,
                    btn:['确定'],
                    btnAlign: 'c'
                });
            }
        } else {
            layer.msg(file.name + '没有类型, 无法识别',{
                type: 1,
                title: '警告',
                closeBtn : 0,
                btn:['确定'],
                btnAlign: 'c'
            });
        }
    }
    return arrFiles;

}
function uploadMobileImg(id) {
    var mobileFile = document.getElementById(id);
    var files = mobileFile.files; //获取的图片文件
    files=validateUp(files);
    if(files.length<=0){
        return false;
    }
    // 验证通过图片异步上传
    var url = "/web/attachment/upload";
    var filesName = "urlfile";
    var module = "mobileEditor";
    var data = new FormData();
    //formdata参数插入
    data.append('module', module);
    data.append(filesName, files[0]);
    $.ajax({
        type: 'POST',
        url: url,
        data: data,
        processData: false,
        contentType: false,
        dataType: 'json',
        // jsonp:'callback',
        beforeSend: function (xhr) {
            xhr.setRequestHeader("X-Custom-Header1", "Bar");
        },
        success: function (data) {
            if(data.success){
                addModule(1,data.data);
                layer.alert("上传成功", {icon: 1,title: '提示',closeBtn: 0,btnAlign: 'c'});
            }else{
                layer.alert(data.message, {icon: 2,title: '失败',closeBtn: 0,btnAlign: 'c'});
            }
        },
        error: function (e) {
            layer.alert("上传失败，请联系管理员！", {icon: 2,title: '失败',closeBtn: 0,btnAlign: 'c'});
        }
    });
}

function uploadMobileAudio(id) {
    var audioFile = document.getElementById(id);
    var files = audioFile.files; //获取的音频文件
    // 验证通过图片异步上传
    var url = "/web/attachment/uploadAudio";
    var filesName = "urlfile";
    var module = "mobileEditor";
    var data = new FormData();
    //formdata参数插入
    data.append('module', module);
    data.append(filesName, files[0]);
    $.ajax({
        type: 'POST',
        url: url,
        data: data,
        processData: false,
        contentType: false,
        dataType: 'json',
        // jsonp:'callback',
        beforeSend: function (xhr) {
            xhr.setRequestHeader("X-Custom-Header1", "Bar");
        },
        success: function (data) {
            if(data.success){
                addModule(3,data.data);
                layer.alert("上传成功", {icon: 1,title: '提示',closeBtn: 0,btnAlign: 'c'});
            }else{
                layer.alert(data.message, {icon: 2,title: '失败',closeBtn: 0,btnAlign: 'c'});
            }
        },
        error: function (e) {
            layer.alert("上传失败，请联系管理员！", {icon: 2,title: '失败',closeBtn: 0,btnAlign: 'c'});
        }
    });
}

function uploadMobileVideo(id) {
    var audioFile = document.getElementById(id);
    var files = audioFile.files; //获取的音频文件
    // 验证通过图片异步上传
    var url = "/web/attachment/uploadVideo";
    var filesName = "urlfile";
    var module = "mobileEditor";
    var data = new FormData();
    //formdata参数插入
    data.append('module', module);
    data.append(filesName, files[0]);
    $.ajax({
        type: 'POST',
        url: url,
        data: data,
        processData: false,
        contentType: false,
        dataType: 'json',
        // jsonp:'callback',
        beforeSend: function (xhr) {
            xhr.setRequestHeader("X-Custom-Header1", "Bar");
        },
        success: function (data) {
            if(data.success){
                addModule(4,data.data);
                layer.alert("上传成功", {icon: 1,title: '提示',closeBtn: 0,btnAlign: 'c'});
            }else{
                layer.alert(data.message, {icon: 2,title: '失败',closeBtn: 0,btnAlign: 'c'});
            }
        },
        error: function (e) {
            layer.alert("上传失败，请联系管理员！", {icon: 2,title: '失败',closeBtn: 0,btnAlign: 'c'});
        }
    });
}

function showProduct(){
    layer.open({
        type: 2,
        title: '添加商品',
        closeBtn : 1,
        area: ['950px','650px'],
        btn:['确定','取消'],
        btnAlign: 'c',
        shadeClose:true,
        content: '/web/product/toConsultationProductPage',
        btn1:function(index){
            var flg = true;
            var frame=$(window.frames[0].document);
            var list = [];
            $.each(frame.find("input[name='productId']"),function(){
                var checkbox = $(this);
                if(checkbox.prop("checked")){
                    var productId = this.value;
                    var img = checkbox.parent().parent().find("img");
                    var imgUrl = img.attr("src");
                    var str=productId+","+imgUrl;
                    list.push(str);
                    flg=false;
                }
            });
            if(flg){
                layer.alert("请选择商品", {icon: 2,title: '请选择',closeBtn: 0,btnAlign: 'c'});
            }
            for(var i = 0;i<list.length;i++){  //循环LIST
                var value = list[i];//获取LIST里面的对象
                addModule(2,value);
            }
            layer.close(index);
        }
    });
}