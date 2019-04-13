function go(url) {
	window.location = url;
}

function deleteContact(url) {
	var isOK = confirm("Are you sure to delete?");
	if (isOK) {
		go(url);
	}
}
function deleteContext(url,context) {
	var isOK = confirm(context);
	if (isOK) {
		go(url);
	}
}
function po(obj, property, func) {
	// eval(obj.functionname);
	var str = '';
	for (prop in obj) {
		if (typeof(obj[prop]) != 'function') {
			if (property != false) {
				str += prop + ':' + obj[prop] + '\n';
			}
		} else if (func != false) {
			str += prop + ':' + typeof(obj[prop]) + '\n';
		}
	}
	return str;
}

function trim(str, chars) {
	return ltrim(rtrim(str, chars), chars);
}
function ltrim(str, chars) {
	chars = chars || "\\s";
	return str.replace(new RegExp("^[" + chars + "]+", "g"), "");
}

function rtrim(str, chars) {
	chars = chars || "\\s";
	return str.replace(new RegExp("[" + chars + "]+$", "g"), "");
}

/**
 * 去掉尾巴的符号(逗号)
 * @param str
 * @returns
 */
function end_douhao(str,chars) {
	if(str.endWith(chars)){
		str = str.substring(0,str.length-1);
	}
	return str;
}

String.prototype.endWith=function(str){
	if(str==null||str==""||this.length==0||str.length>this.length)
	  return false;
	if(this.substring(this.length-str.length)==str)
	  return true;
	else
	  return false;
	return true;
};
String.prototype.startWith=function(s){
	  if(s==null||s==""||this.length==0||s.length>this.length)
	   return false;
	  if(this.substr(0,s.length)==s)
	     return true;
	  else
	     return false;
	  return true;
	 }

String.prototype.replaceAll = function(s1,s2){    
	return this.replace(new RegExp(s1,"gm"),s2);    
};






//
//判断值是否为空（null, undefined, "", " " 返回true）
function isEmpty(value) {
    if (value === null || value === undefined || $.trim("" + value).length == 0 || $.trim(value) == "") {
        return true;
    }
    return false;
}
function isNotEmpty(value) {
    return !isEmpty(value);
}

/**
 * 获取url
 * @param url
 * @returns
 */
function getUrlConnector(url) {
    if (url) {
        if (url.lastIndexOf("?") >= 0) {
            return "&";
        }
        return "?";
    }
}
/**
 * url 添加参数，如果已存在，就更新，如果不存在就添加
 * @param url
 * @param paramName
 * @param paramValue
 * @returns {*}
 */
function getURL(url, paramName, paramValue) {
    if (isEmpty(url)) {
        return null;
    }
    //paramValue可以为空，这时要删掉
    if (isEmpty(paramName)) {
        return url;
    }
    var connector = getUrlConnector(url);
    //如果已经有了，就不能加啦
    var has = true;
    if (url.indexOf("?") > 0){
        var params = url.split("?")[1].split("&");
        for (var i = 0; i < params.length; i++) {
            if(params[i].split("=")[0] == paramName){
                if(!isEmpty(paramValue)){

                url = url.replaceAll(params[i],paramName+'='+paramValue);
                }else{
                    url = url.replaceAll("&"+params[i],'');//如果paramValue可以为空，这时要删掉
                }
                has = false;
            }
        }
    }
    if(has){
        url =  url + connector + paramName + "=" + paramValue;
    }
    return url ;
}
