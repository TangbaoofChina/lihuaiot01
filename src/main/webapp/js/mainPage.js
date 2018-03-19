var mainNowTab;
var mianid_of_setinterval;
$(function () {
    menuClickAction();
    /*welcomePageInit();*/
    signOut();
    /*homePage();*/
    $("#tabContent").tabs({
        data: [{
            id: 'home',
            text: '主页',
            url: "/lihuaiot01/jsp/userpage/welcomePage.jsp",
        }],
        showIndex: 0,
        loadAll: false
    });

    document.getElementById("myTab").oncontextmenu = function (ev) {
        //阻止默认事件
        return false;
    };

    //定时刷新报警条数
    mianid_of_setinterval = setInterval(function () {
        mainRealAlarmCountRefresh();
    }, 3000);

});

//关闭右键菜单，很简单
window.onclick = function (e) {

//用户触发click事件就可以关闭了，因为绑定在window上，按事件冒泡处理，不会影响菜单的功能
    document.querySelector('#miantabmenu').style.display = 'none';
}

// 加载欢迎界面
function welcomePageInit() {
    $('#panel').load('/lihuaiot01/jsp/userpage/welcomePage.jsp');
}

// 跳回首页
function homePage() {
    $('.home').click(function () {
        $('#panel').load('/lihuaiot01/jsp/userpage/welcomePage.jsp');
    })
}


// 动作延时
var delay = (function () {
    var timer = 0;
    return function (callback, ms) {
        clearTimeout(timer);
        timer = setTimeout(callback, ms);
    };
})();

function mainRealAlarmCountRefresh() {
    $.ajax({
        type: "GET",
        url: "/lihuaiot01/realAlarm/selectDeviceRealAlarmCount",
        dataType: "json",
        async: true,   // 轻轻方式-异步
        success: function (response) {
            /*console.log(response);*/
            document.getElementById('mainRealAlarmCountlab').innerHTML = response.alarmCount;
        }, error: function (e,XMLHttpRequest, textStatus, errorThrown) {
            if (mianid_of_setinterval !== undefined) {
                clearInterval(mianid_of_setinterval);
            }
            document.getElementById('mainRealAlarmCountlab').innerHTML = "-1";
            //handleAjaxError(XMLHttpRequest.status);
        }
    })
}

// 侧边栏连接点击动作
function menuClickAction() {
    $("#realalarmpng").click(function () {
        var url = $(this).attr("name");
        delay(function () {
            $("#tabContent").data("tabs").addTab({
                id: "realalarmlisttab",
                text: "实时报警",
                closeable: true,
                url: url
            })
        }, 200);
    });
    $(".menu_item").click(function () {
        var url = $(this).attr("name");
        var val = $(this)[0].innerText;
        var id = $(this).attr("id");
        delay(function () {
            $("#tabContent").data("tabs").addTab({
                id: id + "tab",
                text: val,
                closeable: true,
                url: url
            })
        }, 200);
    });
    /*    $(".shortcut").click(function () {
            var url = $(this).attr("name");
            console.log(url);
        });*/
}

function removeOneTabContent(tabName) {
    if (tabName !== undefined) {
        var nowTabContent = document.getElementById(tabName);
        $(nowTabContent).remove();
    }
}

function removeOneTabli(tabName) {
    if (tabName !== undefined) {
        var nowTabli = document.getElementById(tabName + "li");
        $(nowTabli).remove();
    }
}

function removeTabArray(tabArray) {
    for (var i = 0; i < tabArray.length; i++) {
        removeOneTabContent(tabArray[i]);
    }
    for (var i = 0; i < tabArray.length; i++) {
        removeOneTabli(tabArray[i]);
    }
    $('#myTab a:first').tab('show');
}

function mainTabClose() {
    var tabChildNodesName = [];
    tabChildNodesName.push(mainNowTab);
    removeTabArray(tabChildNodesName);
}

function mainAllTabClose() {
    var tabChildNodes = $('.tab-content')[0].childNodes;
    var tabChildNodesName = [];
    for (var i = 0; i < tabChildNodes.length; i++) {
        if (tabChildNodes[i].id === 'home')
            continue;
        tabChildNodesName.push(tabChildNodes[i].id);
    }
    removeTabArray(tabChildNodesName);
}

function mainOthersTabClose() {
    var tabChildNodes = $('.tab-content')[0].childNodes;
    var tabChildNodesName = [];
    for (var i = 0; i < tabChildNodes.length; i++) {
        if (tabChildNodes[i].id === 'home')
            continue;
        if (tabChildNodes[i].id === mainNowTab)
            continue;
        tabChildNodesName.push(tabChildNodes[i].id);
    }
    for (var i = 0; i < tabChildNodesName.length; i++) {
        removeOneTabContent(tabChildNodesName[i]);
    }
    for (var i = 0; i < tabChildNodesName.length; i++) {
        removeOneTabli(tabChildNodesName[i]);
    }
    $('#myTab a:last').tab('show');
}

// 注销登陆
function signOut() {
    $("#signOut").click(function () {
        $.ajax({
            type: "GET",
            url: "/lihuaiot01/account/logout",
            dataType: "json",
            async: true,   // 轻轻方式-异步
            success: function (response) {
                window.location.reload(true);
            }, error: function (response) {

            }
        })
    })
}

// 处理 Ajax 错误响应
function handleAjaxError(responseStatus) {
    var type = 'error';
    var msg = '';
    var append = '';
    if (responseStatus == 403) {
        msg = '未授权操作';
        append = '对不起，您未授权执行此操作，请重新登陆';
        showMsg(type, msg, append);
        // 刷新重新登陆
        delay(function () {
            window.location.reload(true);
        }, 5000);
    } else if (responseStatus == 404) {
        msg = '不存在的操作';
        showMsg(type, msg, append);
    } else if (responseStatus == 430) {
        msg = '您的账号在其他地方登陆';
        append = '请确认是否为您本人的操作。若否请及时更换密码';
        showMsg(type, msg, append);
        // 刷新重新登陆
        delay(function () {
            window.location.reload(true);
        }, 5000);
    } else if (responseStatus == 500) {
        msg = '服务器错误';
        append = '对不起，服务器发生了错误，我们将尽快解决，请稍候重试';
        showMsg(type, msg, append);
    } else {
        msg = '遇到未知的错误';
        showMsg(type, msg, append);
    }
}

// 显示操作结果提示模态框
function showMsg(type, msg, append) {
    $('#info_success').removeClass("hide");
    $('#info_error').removeClass("hide");
    $('#info_warning').removeClass("hide");
    if (type == "success") {
        $('#info_error').addClass("hide");
        $('#info_warning').addClass("hide");
    } else if (type == "error") {
        $('#info_success').addClass("hide");
        $('#info_warning').addClass("hide");
    } else if (type == "warning") {
        $('#info_success').addClass("hide");
        $('#info_error').addClass("hide");
    }
    $('#info_summary').text(msg);
    $('#info_content').text(append);
    $('#global_info_modal').modal("show");
}

// 密码加密模块
function passwordEncrying(userID, password) {
    var str1 = $.md5(password);
    //var str2 = $.md5(str1 + userID);
    return str1;
}

//动态加载一个js/css文件
function loadjscssfile(filename, filetype) {
    if (filetype == "js") {
        var fileref = document.createElement('script')
        fileref.setAttribute("type", "text/javascript")
        fileref.setAttribute("src", filename)
    }
    else if (filetype == "css") {
        var fileref = document.createElement("link")
        fileref.setAttribute("rel", "stylesheet")
        fileref.setAttribute("type", "text/css")
        fileref.setAttribute("href", filename)
    }
    if (typeof fileref != "undefined")
        document.getElementsByTagName("head")[0].appendChild(fileref)
}

//移除已经加载过的js/css
function removejscssfile(filename, filetype) {
    var targetelement = (filetype == "js") ? "script" : (filetype == "css") ? "link" : "none"
    var targetattr = (filetype == "js") ? "src" : (filetype == "css") ? "href" : "none"
    var allsuspects = document.getElementsByTagName(targetelement)
    for (var i = allsuspects.length; i >= 0; i--) {
        if (allsuspects[i] && allsuspects[i].getAttribute(targetattr) != null && allsuspects[i].getAttribute(targetattr).indexOf(filename) != -1)
            allsuspects[i].parentNode.removeChild(allsuspects[i])
    }
}

function createjscssfile(filename, filetype) {
    if (filetype == "js") {
        var fileref = document.createElement('script')
        fileref.setAttribute("type", "text/javascript")
        fileref.setAttribute("src", filename)
    }
    else if (filetype == "css") {
        var fileref = document.createElement("link")
        fileref.setAttribute("rel", "stylesheet")
        fileref.setAttribute("type", "text/css")
        fileref.setAttribute("href", filename)
    }
    return fileref
}

function replacejscssfile(oldfilename, newfilename, filetype) {
    var targetelement = (filetype == "js") ? "script" : (filetype == "css") ? "link" : "none"
    var targetattr = (filetype == "js") ? "src" : (filetype == "css") ? "href" : "none"
    var allsuspects = document.getElementsByTagName(targetelement)
    for (var i = allsuspects.length; i >= 0; i--) {
        if (allsuspects[i] && allsuspects[i].getAttribute(targetattr) != null && allsuspects[i].getAttribute(targetattr).indexOf(oldfilename) != -1) {
            var newelement = createjscssfile(newfilename, filetype)
            allsuspects[i].parentNode.replaceChild(newelement, allsuspects[i])
        }
    }
}

function removealljsfile() {
    removejscssfile("/lihuaiot01/js/userjs/operationcenter.js", "js");
    removejscssfile("/lihuaiot01/js/userjs/realdevicelist.js", "js");
    removejscssfile("/lihuaiot01/js/userjs/hisdevicelist.js", "js");
    removejscssfile("/lihuaiot01/js/userjs/hischartdevice.js", "js");

    removejscssfile("/lihuaiot01/js/adminjs/devicecombineorg.js", "js");
    removejscssfile("/lihuaiot01/js/adminjs/peoplecombineorg.js", "js");
    removejscssfile("/lihuaiot01/js/adminjs/organizemanage.js", "js");

    removejscssfile("/lihuaiot01/js/centerjs/operationcenter.js", "js");

    removejscssfile("/lihuaiot01/js/systemjs/loginrecord.js", "js");

    removejscssfile("/lihuaiot01/js/login.js", "js");
}

window.operateEvents = {
    /*设备组织配置*/
    'click .deviceOrgChangeORG': function (e, value, row, index) {
        $('#deviceOrgNum').val(row.dSerialNum);
        $('#deviceOrgName').val(row.dName);
        deviceOrgSelectDevice = row;
        deviceOrgShowAdd();
    },

    /*用户组织配置*/
    'click .peopleOrgChangeORG': function (e, value, row, index) {
        $('#peopleOrgPeople').val(row.personName);
        peopleOrgSelectPerson = row;
        peopleOrgShowAdd();
    },
    'click .peopleOrgRemoveORG': function (e, value, row, index) {
        peopleOrgSelectPerson = row;
        $('#peopleOrgdelcfmModel').modal();
    },

    /*用户角色配置 */
    'click .rolePeopleChangeDevice': function (e, value, row, index) {
        rolePeopleSelectPeopleRole = row;
        $("#rolePeoplePeopleName").val(rolePeopleSelectPeopleRole.userName);
        $("#rolePeopleRoleName").val(rolePeopleSelectPeopleRole.roleName);
        rolePeopleSelectPeople = rolePeopleSelectPeopleRole;
        rolePeopleSelectRole = rolePeopleSelectPeopleRole;
        rolePeopleShowAdd();
    },
    'click .rolePeopleRemoveRole': function (e, value, row, index) {
        rolePeopleSelectPeopleRole = row;
        $('#rolePeopledelcfmModel').modal();
    },

    /*角色配置*/
    'click .roleChangeDevice': function (e, value, row, index) {
        roleSelectRole = row;
        updateRoleDeviceSelEnd();
        $('#roleModifyName').val(row.roleName);
        $('#roleModifyDescribe').val(row.roleDescribe);
        roleShowModify();
    },
    'click .roleRemoveRole': function (e, value, row, index) {
        roleSelectRole = row;
        $('#roledelcfmModel').modal();
    }
};