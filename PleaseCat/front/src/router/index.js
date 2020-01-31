import Vue from 'vue'
import VueRouter from 'vue-router'
// import Login_id from '../components/member/login/PageLogin_id'
import Test from '../components/Test.vue'
import Login from '../components/member/login/PageLogin'
import SignUp from '../components/member/signup/PageSignUp'
import Home from '../components/newsfeed/Home.vue'
import NewsFeed from '../components/newsfeed/NewsFeed.vue'
import PageCatList from '../components/catList/PageCatList.vue'
import PageCatProfile from '../components/catProfile/PageCatProfile.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'NewsFeed',
    component: NewsFeed
  },
  {
    path: '/Home',
    name: 'Home',
    component: Home
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/test',
    name: 'Test',
    component: Test
  },
  {
    path: '/catList',
    name: 'PageCatList',
    component: PageCatList
  },
  {
    path: '/signUp',
    name: 'SignUp',
    component: SignUp
  },
  {
    path: '/catProfile',
    name: 'PageCatProfile',
    component: PageCatProfile
  },
  // {
  //   path: '/login_id',
  //   name: 'login_id',
  //   component: Login_id
  // },
  // {
  //   path: '/about',
  //   name: 'about',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../components/about/About.vue')
  // }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
