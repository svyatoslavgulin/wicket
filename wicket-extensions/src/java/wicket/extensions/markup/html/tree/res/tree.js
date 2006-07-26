if (typeof(Wicket) == "undefined")
	Wicket = { };

Wicket.Tree = { };

Wicket.Tree.removeNodes = function(prefix, nodeList) {
	for (var i in nodeList) {
		var e = document.getElementById(prefix + nodeList[i]);
		if (e != null) {
			e.parentNode.removeChild(e);
		} else {
			// while developing alert a warning
			alert("Can't find node with id " + prefix + nodeList[i] + ". This shouldn't happen - possible bug in tree?");
		}
	}
}

Wicket.Tree.createElement = function(elementId, afterId) {
	var after = document.getElementById(afterId);
	var newNode = document.createElement("script");
	newNode.setAttribute("id", elementId);

	var p = after.parentNode;

	for (var i = 0; i < p.childNodes.length; ++i) {
		if (after == p.childNodes[i])
			break;
	}
	if (i == p.childNodes.length - 1) {
		p.appendNode(newNode);
	} else {
		p.insertBefore(newNode, p.childNodes[i+1]);
	}
}
