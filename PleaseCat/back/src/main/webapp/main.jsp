<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.card-box {
    margin: 10px;
    -webkit-transform: perspective(1000px);
    transform: perspective(1000px);
    -webkit-transform-style: preserve-3d;
    transform-style: preserve-3d;
    min-width: 300px;
    max-width: 380px;
}

.card {
    position: relative;
    width: 100%;
    height: 350px;
    overflow: hidden;
    background-color: #000;
    box-shadow: 0px 5px 15px 0px rgba(48, 54, 62, 0.7);
    border-radius: 10px;
}
.card.hover{
    transition:box-shadow 0.5s;
}
.card-box .card.hover{
    z-index:10;
    box-shadow: 0px 20px 40px 10px rgba(48, 54, 62, 0.8);
}

.card.ani{
    transition: 0.8s cubic-bezier(0.23, 1, 0.32, 1);
    -webkit-transition: 0.8s cubic-bezier(0.23, 1, 0.32, 1);
}
.card.ani .bg{
    transition: background-position 0.5s cubic-bezier(0.23, 1, 0.32, 1),opacity 0.5s;
    -webkit-transition: background-position 0.5s cubic-bezier(0.23, 1, 0.32, 1),opacity 0.5s;
}

.card.hover .bg{
    opacity: 1;
}
.card .bg {
    position: absolute;
    top: -30px;
    left: -30px;
    width: calc(100% + 60px);
    height: calc(100% + 60px);
    background-repeat: no-repeat;
    background-position: 0 0;
    background-size: cover;
    opacity: 0.7;
    transition:opacity 0.3s;
}


.card .info {
    position: absolute;
    bottom: 20PX;
    right: 20PX;
    transition:all 0.4s ease-out;
}
.card.hover .info{
    text-shadow:rgba(0, 0, 0, 0.5) 0 5px 10px
}
.card .info h1 {
    display: inline-block;
    color: #fff;
    font-size: 20px;
    font-weight: normal;
}
</style>
</head>
<body>
<script type="text/javascript">
var hoverCard = {
	    width: 0,
	    height: 0,
	    startX:0,
	    startY:0,
	    mouseX: 0,
	    mouseY: 0,
	    postionX: function () {
	        return this.mouseX / this.width;
	    },
	    positionY: function () {
	        return this.mouseY / this.height;
	    },
	    cardTransform: function (target) {
	        var rx = this.postionX() * 30;
	        var ry = this.positionY() * -30;
	        return target.children[0].style.transform = 'rotateY(' + rx + 'deg)' + ' ' + 'rotateX(' + ry + 'deg)';
	    },
	    cardBgTransform: function (target) {
	        var bx = this.postionX() * -50;
	        var by = this.positionY() * -50;
	        return target.children[0].children[0].style.backgroundPosition = bx + 'px' + ' ' + by + 'px';
	    },
	    handleEnter: function (target, e) {
	        this.width = target.clientWidth;
	        this.height = target.clientHeight;
	        this.startX=e.pageX;
	        this.startY=e.pageY;
	        target.children[0].classList.add('hover');
	    },
	    handleMove: function (target, e) {
	        if(Math.abs(this.startX-e.pageX)>50){
	            target.children[0].classList.remove('ani');
	        }
	        this.mouseX = e.pageX - target.offsetLeft - this.width / 2;
	        this.mouseY = e.pageY - target.offsetTop - this.height / 2;
	        this.cardTransform(target);
	        this.cardBgTransform(target);
	    },
	    handleLeave: function (target) {
	        this.mouseX = 0;
	        this.mouseY = 0;
	        target.children[0].classList.add('ani');
	        target.children[0].classList.remove('hover');
	        this.cardTransform(target);
	        this.cardBgTransform(target);
	    }
	}
</script>

<div class="card-box"
            onmouseenter="hoverCard.handleEnter(this,event)" onmousemove="hoverCard.handleMove(this,event)" onmouseleave="hoverCard.handleLeave(this)">
            <div class="card ani">
                <div class="bg" style="background-image:url('images/space01.png')"></div>
                <div class="info">
                    <h1>HOVER ME</h1>
                </div>
            </div>
</div>
</body>
</html>