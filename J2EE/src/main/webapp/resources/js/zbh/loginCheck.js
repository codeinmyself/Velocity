function loginCheck()
{
	var check = document.getElementById("registerCheck");
	var mp = document.getElementById("mobilePhone").value;
	var psw = document.getElementById("password").value;
	var pswc = document.getElementById("passwordCheck").value;
	var nn = document.getElementById("nickname").value;
	if(mp+psw=="")
	{
		alert("手机号和密码不能为空！");
		return false;
	}
	else if(mp=="")
	{
		alert("手机号不能为空！");
		return false;
	}
	else if(psw=="")
	{
		alert("密码不能为空！");
		return false;
	}
	else if(pswc=="")
	{
		alert("请确认密码！");
		return false;
	}
	else if(psw!=pswc)
	{
		alert("两次输入的密码不一致！");
		return false;
	}
	else if(nn=="")
	{
		alert("昵称不能为空！");
		return false;
	}
	else 
		return true;

}