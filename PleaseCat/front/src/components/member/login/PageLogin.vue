<template>
  <div class="login">
    <div class="input-wrap">
      <div class="input_row">
        <label for="id">ID</label>
        <input type="text" v-model="user_email " id="id" placeholder="이메일을 입력하세요." />
      </div>
      <div class="input_row">
        <label for="password">비밀번호</label>
        <input
          type="password"
          id="password"
          v-model="user_pw"
          @keyup.enter="login"
          placeholder="비밀번호를 입력하세요."
        />
      </div>
    </div>

    <div class="btn-wrap">
      <a  href="/signUp">가입하기</a>
      <button class="btn-login" v-on:click="login">로그인</button>
    </div>
  </div>
</template>


<script>
import UserApi from "../../../apis/UserApi";

export default {
  data() {
    return {
      user_email: "",
      user_pw: "",
      error: {
        user_email: false,
        user_pw: false
      },
      idChecked: false,
      pwChecked: false
    };
  },

  methods: {
    login() {
      // id, pw가 DB에 존재하는지 확인
      let { user_email, user_pw } = this;
      let data = {
        user_email,
        user_pw
      };

      UserApi.requestLogin(
        data,
        res => {
          if (res.status == 200) {
            if (res.data.state == "ok") {
              //성공
              this.$router.push("/");
            } else {
              //실패
            }
          }
        },
        error => {
          //요청이 끝나면 버튼 활성화
          // console.log("리턴")
          console.log("서버 에러");
          this.isSubmit = true;
        }
      );
    }
  }
};
</script>

<style lang="scss" scoped>
.login {
  width: 350px;
  margin: 0 auto;
  margin-top: 10px;
  margin-bottom: 60px;
  padding-top: 100px;
}
.login label {
  display: inline-block;
  max-width: 100%;
  margin-bottom: 5px;
  font-weight: 700;
}
.login input {
  width: 100%;
  background: 0 0; //? 이게 무슨 속성일까!
  border: 1px solid rgb(250, 206, 231);
  border-radius: 6px;
  box-sizing: border-box;
  color: rgb(248, 44, 163);
  font-size: 14px;
  padding: 7px 8px 7px;
}
.input-wrap .input_row {
  margin-bottom: 25px;
}
.btn-wrap {
  margin-bottom: 25px;
  color:rgb(248, 51, 160);
}
.btn-wrap a:link {
  color: rgb(248, 51, 160);
}
.btn-wrap a:link, a:visited {
  color: rgb(248, 51, 94);
}
.btn-wrap .btn-login {
  background: rgb(248, 51, 160);
  border-color: rgb(248, 51, 160);
  color: #fff;
  border-radius: 6px;
  border-style: solid;
  border-width: 1px;
  font-size: 14px;
  font-weight: 600;
  line-height: 28px;
  outline: none;
  width: 40%;
  padding: 0%;
  float: right;
  // margin-left: 80%;
  cursor: pointer;

}
</style>