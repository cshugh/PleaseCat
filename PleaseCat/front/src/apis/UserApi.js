import axios from 'axios'
import qs from 'qs'

const UserApi = {
    requestLogin: (data, callback, errorCallback) => requestLogin(data, callback, errorCallback)
    , requestSignup: (data, callback, errorCallback) => requestSignup(data, callback, errorCallback)
}

const requestLogin = (data, callback, errorCallback) => {
    //백앤드와 로그인 통신하는 부분
    axios.get(`http://localhost:8080/api/user/login?user_email=${data.user_email}&user_pw=${data.user_pw}`)
        .then((res) => {
            callback(res);
        })
        .catch((err) => {
            errorCallback(err);
        });

}
const requestSignup = (data, callback, errorCallback) => {
    axios.post(`http://localhost:8080/api/user/insert`, {
            user_id: data.user_id,
            user_pw: data.user_pw,
            user_email: data.user_email,
        })
        .then((res) => {
            callback(res);
        })
        .catch((err) => {
            errorCallback(err);
        });

}


export default UserApi
