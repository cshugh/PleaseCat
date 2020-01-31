<template>
<div>
  <!-- <header>
    <h1>뉴스피드</h1>
  </header>-->
  <body>
    <div id="repeat" v-for="post in posts" :key="post.post_no">
      <div id="top">
        <div class="top">
          <router-link v-bind:to="{name:'Home'}">
            <button id="profileButton">
              <img :src="require('../../assets/images/' + post.post_image)" id="profile" />
            </button>
          </router-link>
        </div>
        <div class="top">{{post.cat_no}}</div>
        <div class="top" id="time">{{post.post_time}}</div>
      </div>
      <div id="content">
        <img :src="require('../../assets/images/' + post.post_image)" id="img" />
      </div>
      <div id="HR">
        <div class="HR">
          <img :src="require('../../assets/images/abc.jpeg')" class="HRSize"/>
        </div>
        <div class="HR">
          <img :src="require('../../assets/images/abc.jpeg')" class="HRSize"/>
        </div>
      </div>
      <div class="like">
        좋아요 
      </div>
      <div class="like">
        {{post.post_no}}개, 
      </div>
      <div class="like">
        싫어요 
      </div>
      <div class="like">
        {{post.post_no}}개 
      </div>
      <div class="content">
        {{post.user_no}}
      </div>
      <div class="content">
        {{post.post_content}}
      </div>
      <!-- <div>{{post.post_image}}</div> -->
    </div>
    <infinite-loading @infinite="infiniteHandler" spinner="waveDots"></infinite-loading>
  </body>
  <!-- <footer>
    <router-link v-bind:to="{name:'Home'}">
      <button class="Img">
        <img id="home" v-bind:src="homeImg" />
      </button>
    </router-link>
    <img class="Img" v-bind:src="location" />
    <img class="Img" v-bind:src="plus" />
    <img class="Img" v-bind:src="search" />
    <img class="Img" v-bind:src="profile" />
  </footer>-->
</div>
</template>/
<script>
import axios from "axios";
import "../../assets/css/style.css";
import InfiniteLoading from "vue-infinite-loading";

const api = "http://70.12.247.116:8080/api/post/searchPostUser/{User_no}?User_no=1";
// import Vue from 'vue'
export default {
  created() {
    // this.homeImg = require("../../assets/images/"+1+".jpeg");
    // this.location = require("../../assets/images/home.jpeg");
    // this.plus = require("../../assets/images/plus.png");
    // this.search = require("../../assets/images/search.jpg");
    // this.profile = require("../../assets/images/profile.png");
  },
  components: {
    InfiniteLoading
  },
  methods: {
    infiniteHandler($state) {
      axios
        .get(api, {
          params: {
            page: this.page
          }
        })
        .then(({ data }) => {
          console.log(data);
          if (data.data.length > this.page) {
            this.posts.push(data.data[this.page]);
            this.page += 1;
            $state.loaded();
          } else {
            state.complete();
          }
          console.log(this.posts);
        });
    }
  },
  data: () => {
    return {
      page: 0,
      // posts: {
      //   post_no: "",
      //   user_no: "",
      //   cat_no: "",
      //   post_image: "",
      //   post_time: "",
      //   post_content: "",
      //   post_like: "",
      //   post_unlike: "",
      //   post_report: "",
      //   post_location: ""
      // },
      posts: [],
      cat_profile: "",
      email: "",
      homeImg: "",
      location: "",
      plus: "",
      search: "",
      profile: ""
    };
  }
};
</script>
 
<style lang="scss" scoped>
.content{
  font-size: 3vw;
}

.HR{
  display: inline;
}
.HRSize{
  width: 9%;
}
.like{
  font-size: 3vw;
  display: inline;
}
#content {
  height: 100%;
  font-size: 0;
  line-height: 0;
}
#img {
  width: 100%;
}
.top {
  font-size: 3vw;
  display: inline;
}
#time {
  height: 100%;
  float: bottom;
  float: right;
}
#repeat {
  background-color: black;
  color: white;
  width: 100%;
  justify-content: space-between;
  align-items: center;
}
#profile {
  width: 100%;
  
  border-radius: 100%;
}
#profileButton{
  width: 10%;
}
</style>