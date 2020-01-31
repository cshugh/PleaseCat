<template>
    <div id="test">
    </div>
</template>

<script>
import CatCardComponent from './catList/catCard/CatCard'
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
        
    }
}
</script>