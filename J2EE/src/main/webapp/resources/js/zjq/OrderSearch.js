/**
 * Created by Administrator on 2017/5/23.
 */
function reset() {
    $(".total-input").val('');
    $("select").each(function () {
        $(this).children("option:first").prop("selected","selected");
    })
}
function search() {
    var ordersn=document.getElementById("order_sn").value;
    if(ordersn=='') ordersn="empty";
    var goodsname=document.getElementById("goods_name").value;
    if(goodsname=='') goodsname="empty";
    var addtimebegin=document.getElementById("add_time_begin").value;
    if(addtimebegin=='') addtimebegin="0";
    var addtimeend=document.getElementById("add_time_end").value;
    if(addtimeend=='') addtimeend="0";
    var consignee=document.getElementById("consignee").value;
    if(consignee=='') consignee="empty";
    var isUrgency=$("#isUrgency option:selected").val();
    var orderstatus=$("#order_status option:selected").val();
    if(orderstatus=='请选择订单状态') orderstatus='6';
    var searchobject={
        ordersn:ordersn,
        goodsname:goodsname,
        addtimebegin:addtimebegin,
        addtimeend:addtimeend,
        consignee:consignee,
        isUrgency:isUrgency,
        orderstatus:orderstatus
    }
    sessionStorage.setItem("search","yes");
    sessionStorage.setItem("searchobject",JSON.stringify(searchobject));
    window.location.href="Search";
}
function goback() {
    window.location.href="OrderManage";
}
