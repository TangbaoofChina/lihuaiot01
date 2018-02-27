$(function () {
    quickAccessInit();
});

// 快捷方式
function quickAccessInit() {
    $('.shortcut').click(function () {
        var title = $(this).find('.title').text();
        var url = $('.menu_item:contains(' + title + ')').attr('name');
        var id = $('.menu_item:contains(' + title + ')').attr("id");
        delay(function () {
            $("#tabContent").data("tabs").addTab({
                id: id + "tab",
                text: title,
                closeable: true,
                url: url
            })
        }, 200);
    })
}