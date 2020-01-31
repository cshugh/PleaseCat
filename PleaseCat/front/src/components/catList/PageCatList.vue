<template>
    <div id="catList">
        <!-- <CatCardComponent key="1" name="name" desc1="♀" desc2="loca" src="1" /> -->
        <CatCardComponent v-for="cat in cats" :key=cat.cat_no :name=cat.cat_name :desc1="cat.sex==='남'?'♂':'♀'" :desc2=cat.cat_location :src=cat.cat_no  />
    <div class="emptySpace"></div>
    </div>
</template>
<script>
import CatCardComponent from './catCard/CatCard'
import axios from 'axios'

export default {
    created() {
        this.pullCat();
    },
    data() {
      return {
          cats: []
      }
    },
    components: {
        CatCardComponent,
    },
    methods: {
        pullCat(){
            const vm = this;
            axios
                .get('http://70.12.247.116:8080/api/cat/searchAll')
                .then(res => {
                    // handle success
                    vm.cats = res.data.data
                    res.data.data.forEach(el => {
                        
                    });
                })
                .catch(err =>  {
                    // handle error
                })
                .then(() => {
                    // always executed
                    console.log(vm.cats);
                });
        }
    }
}
</script>

<style>
#catList{
    /* padding-bottom: 75px; */
    
}
.emptySpace {
    height: 75px;
}
</style>