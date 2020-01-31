<template>
  <div class="login">
    <div class="input_row">
        <label for="id">ID</label>
        <input v-model="id" @keyup.enter="login_next"
            id="id" placeholder="이메일을 입력하세요."
            type="text"/>
</div>
<!-- <div class="input_row">
   <label for="password">비밀번호</label>
   <input type="password" id="password" v-model="user.password">
</div> -->
<button v-on:click="login_next">다음</button>
<a href="/signUp">가입하기</a>
</div>

</template>

<script>
  export default{
    data: () => {
        return {
            email: '',
            password: '',
            error: {
                email: false,
                passowrd: false,
            },
            idChecked: false,
            // passwordType: "password",
            // passwordConfirmType: "password",
        }
    },
    methods: {
        // login_next() {
        //     let idChecked = false;
            
        //     // id가 DB에 존재하는지 확인
        //     // User DB에 해당 아이디가 존재하면 idChecked=true

        //     // if(idChecked) {
        //         // email을 
        //     // }
        // },

    },


  }

</script>