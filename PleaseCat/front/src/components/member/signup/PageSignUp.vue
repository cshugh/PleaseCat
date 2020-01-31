<template>
  <div class="signup">
    <!-- 입력받을 정보: name, email, id, pw, image, desc -->

    <div class="signup_input">
      <label for="id">ID</label>
      <input type="text" id="id" v-model="user_id" placeholder="아이디를 입력하세요" />
    </div>
    <div class="signup_input">
      <label for="password">PW</label>
      <input type="password" id="password" v-model="user_pw" placeholder="비밀번호를 입력하세요" />
    </div>
    <div class="signup_input">
      <label for="email">Email</label>
      <input type="email" id="email" v-model="user_email" placeholder="이메일을 입력하세요" />
    </div>
    <div class="signup_input">
      <label for="name">Name</label>
      <input type="name" id="name" v-model="user_name" placeholder="이름을 입력하세요" />
    </div>

    <button v-on:click="signup">Create Account</button>
  </div>
</template>

<script>
import UserApi from "../../../apis/UserApi";
export default {
  data() {
    return {
      user_id: "",
      user_pw: "",
      user_email: "",
      user_name: "",

      error: {
        user_id: false,
        user_pw: false,
        user_email: false,
        user_name: false
      }
    };
  },

  methods: {
    signup() {
      let { user_id, user_pw, user_email, user_name } = this;
      let data = {
        user_id,
        user_pw,
        user_email,
        user_name
      };

      UserApi.requestSignup(
        data,
        res => {
          if(res.status == 200) {
            if(res.data.state="ok") {
              this.$router.push('/')
            }else{
              // 실패
            }
          }
        },
        error => {
          console.log("서버 에러")
        }
      )

    }
  }
};
</script>

<style lang="scss" scoped>

</style>