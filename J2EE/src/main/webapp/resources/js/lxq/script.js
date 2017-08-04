function gotoGoods(goods_id){
	window.location.href = "../index/goodsDetail/"+goods_id;
}
function gotoCollect(user_id) {
	window.location.href = "my_collect_body?user_id=" + user_id;
}
function gotoAddress(user_id) {
	window.location.href = "address_body?user_id=" + user_id;
}
function gotoUserInfo(user_id) {
	window.location.href = "user_info_body?user_id=" + user_id;
}
function changeStatus(user_id, order_id, order_status) {
	window.location.href = "changeOrderStatus?user_id=" + user_id
			+ "&order_id=" + order_id + "&order_status=" + order_status;
}
function cancelCollect(user_id, goods_id) {
	window.location.href = "cancelCollect?user_id=" + user_id + "&goods_id="
			+ goods_id;
}
function gotoEditAddress1(user_id, address_id) {
	window.location.href = "editAddress?user_id=" + user_id + "&address_id="
			+ address_id;
}
function gotoEditAddress2(user_id) {
	window.location.href = "editAddress?user_id=" + user_id;
}
function gotoRegion(user_id) {
	var address_id = document.getElementById("address_id").value;
	var consignee = document.getElementById("consignee").value;
	var telephone = document.getElementById("telephone").value;
	var province = document.getElementById("province").value;
	var city = document.getElementById("city").value;
	var district = document.getElementById("district").value;
	var detail = document.getElementById("detail").value;
	var is_default;
	var obj = document.getElementsByName("is_default");
	for (var i = 0; i < obj.length; i++) {
		if (obj[i].checked) {
			is_default = obj[i].value;
		}
	}
	window.location.href = "region?user_id=" + user_id + "&address_id="
			+ address_id + "&consignee=" + consignee + "&telephone="
			+ telephone + "&province=" + province + "&city=" + city
			+ "&district=" + district + "&detail=" + detail + "&is_default="
			+ is_default;
}
function selectCity() {
	var province_val = $("#selectprovince").val();
	alert(province_val);

	var html = "<option style='font-size:0.5em;'>--请选择--</option>";
	var CommitUrl = "http://localhost:8080/JavaEE/user/regionCity";


	$.ajax({
		type : "POST",
		url : CommitUrl,
		dataType : 'json',
		data:{
			province:$("#selectprovince").val()
		},
		success : function(result) {
		
			var goal = $.extend(true, [], result);
			for (var i = 0; i < goal.cities.length; i++) {
				html += "<option  style='font-size:0.5em;' value='"
						+ goal.cities[i].region_id + "'>"
						+ goal.cities[i].region_name + "</option>";
			}
			$("#selectcity").empty();
			$("#selectdistrict").empty();
			$(html).appendTo("#selectcity");
	
		}
	});
	
}
function selectDistrict() {
	var province_val = $("#selectcity").val();
	var html = "";
	var CommitUrl = "region_district.do?city=" + province_val;

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : CommitUrl,
		dataType : 'json',
		success : function(result) {
			var goal = $.extend(true, [], result);
			for (var i = 0; i < goal.districts.length; i++) {
				if (i == 0) {
					html += "<option style='font-size:0.5em;' value='"
							+ goal.districts[i].region_id + "' selected>"
							+ goal.districts[i].region_name + "</option>";
				} else {
					html += "<option  style='font-size:0.5em;' value='"
							+ goal.districts[i].region_id + "'>"
							+ goal.districts[i].region_name + "</option>";
				}
			}
			$("#selectdistrict").empty();
			$(html).appendTo("#selectdistrict");
		}
	});
}
function changeRegion(form) {
	form.province.value = $("#selectprovince").val();
	form.city.value = $("#selectcity").val();
	form.district.value = $("#selectdistrict").val();
}
function gotoDelete(user_id, address_id) {
	var result = confirm("是否删除");
	if (result) {
		window.location.href = "deleteAddress?user_id=" + user_id
				+ "&address_id=" + address_id;
	}
}
function sDialog() {
	document.getElementById("file").click();
}
