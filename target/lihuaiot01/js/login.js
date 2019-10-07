var loginPubExponent;
var loginPubModules;

$(function () {
    $.ajax({
        url:"/lihuaiot01/account/beforeLogin",
        dataType:"text",
        type:"GET",
        success:function (data) {
            var jn = $.parseJSON(data);
            loginPubExponent = jn.pubexponent;
            loginPubModules = jn.pubmodules;
        },
        error:function (XMLHttpRequest) {
            alert(XMLHttpRequest.status);
        }
    });
    validatorInit();
});

function validatorInit() {
    $('#login_form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            userID: {
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    },
                    callback: {}
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    callback: {}
                }
            }
        }
    })
        .on('success.form.bv', function (e) {
            // 禁用默认表单提交
            e.preventDefault();

            // 获取 form 实例
            var $form = $(e.target);
            // 获取 bootstrapValidator 实例
            var bv = $form.data('bootstrapValidator');

            // 发送数据到后端 进行验证
            var username = $('#userID').val();
            var password = $('#password').val();
            password = myTirm(password);
            //加密
            var key = new RSAUtils.getKeyPair(loginPubExponent, "",loginPubModules);
            var encrypedPwd = RSAUtils.encryptedString(key,password);

            $.ajax({
                url: "/lihuaiot01/account/login",
                type: "POST",
                dataType: "json",
                data: {username: username, userpwd: encrypedPwd},
                success: function (response) {
                    // 接收到后端响应

                    // 分析返回的 JSON 数据
                    if (response.result == 'error') {
                        var errorMessage;
                        var field;
                        if (response.msg == "unknownAccount") {
                            errorMessage = "用户名错误";
                            field = "userID";
                        }
                        else if (response.msg == "incorrectCredentials") {
                            errorMessage = "密码错误";
                            field = "password";
                            $('#password').val("");
                        }else if(response.msg == "already login"){
                            window.location.href = "/lihuaiot01";
                        }else {
                            errorMessage = "服务器错误";
                            field = "password";
                            $('#password').val("");
                        }

                        // 更新 callback 错误信息，以及为错误对应的字段添加 错误信息
                        bv.updateMessage(field, 'callback', errorMessage);
                        bv.updateStatus(field, 'INVALID', 'callback');

                    } else {
                        // 页面跳转
                        window.location.href = "/lihuaiot01";
                    }
                },
                error: function (data) {
                    // 处理错误
                    console.log(data);
                }
            });
        });
}
