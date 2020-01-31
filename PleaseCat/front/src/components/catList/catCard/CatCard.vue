<template>
  <div class="card-box" >
      <router-link :to="{name:'PageCatProfile', params: {no: src}}">
      <div class="card" :class="{hover: isHovering}" @mouseover="isHovering=true" @mouseout="isHovering=false">
          <div class="bg" :style="{'background-image': 'url('+require(`../../../assets/images/cat/${src}.jpg`)+')'}"></div>
          <div class="text name">
              <h3>{{name}}</h3>
          </div>
          <div class="text desc1">
              <h4>{{desc1}}</h4>
          </div>
          <div class="text desc2">
              <img src=""/>
              <h5>{{desc2}}</h5>
          </div>
      </div>
      </router-link>
  </div>
</template>
<script>
export default {
  name: 'CatCard',
  props: ['name', 'desc1', 'desc2', 'src'],
  data() {
      return {
          isHovering: false,
      }
  },
}
</script>

<style lang="scss" scoped>
@import url(//fonts.googleapis.com/earlyaccess/notosanskr.css);

.card-box {
    position: relative;
    margin: 10px;
    width: 40%;
    // border: 1px solid red;
    display: inline-block;
}
.card-box:after{
    content: "";
    display: block;
    padding-bottom: 100%;
}
.card {
    position: absolute;
    width: 100%;
    height: 100%;
    overflow: hidden;
    background-color: #000;
    box-shadow: 10px 10px 15px 0px rgba(48, 54, 62, 0.7);
    border-radius: 30px;
    height: 100%;
}

.card .bg {
    top: -30px;
    left: -100px;
    width: calc(100%);
    height: calc(100%);
    background-repeat: no-repeat;
    background-position: 0 0;
    background-size: cover;
    opacity: 0.5;
    transition:opacity 0.3s;
}
.card.hover .bg {
    opacity: 1.0;
    transition:opacity 0.3;
}
.card .text {
    position: absolute;
    transition:all 0.4s ease-out;
    text-shadow: 4px 2px 2px black;
    font-weight: bold;
    font-family: "Noto Sans KR", sans-serif;
    color: #fff;
}
.card .text h1 {
    display: inline-block;
}
.name{
    top: 20PX;
    left: 20PX;
}
.desc1{
    top: 20PX;
    right: 20PX;
}
.desc2{
    bottom: 20PX;
    right: 20PX;
}
</style>