
function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)
    	 return  unescape(r[2]); 
     return null;
}

function set_tab() {
    var tab_tag = GetQueryString("stat");
    var inputs = document.getElementsByTagName("a");
    for (var i = 0; i < inputs.length; i++) {
        if (inputs[i].id == tab_tag) {
            inputs[i].setAttribute("class","mdl-layout__tab is-active");
        }
        else if (inputs[i].classList.contains("is-active")) {
            inputs[i].setAttribute("class","mdl-layout__tab");
        }
    }
}

