<template>
  <div style="position: fixed;  bottom: 0;  left: 0;  right: 0; z-index:100;">
    <v-tabs
      v-model="tab"
      background-color="pink"
      class="elevation-2"
      dark
      :centered="centered"
      :grow="grow"
      :vertical="vertical"
      :right="right"
      :prev-icon="prevIcon ? 'mdi-arrow-left-bold-box-outline' : undefined"
      :next-icon="nextIcon ? 'mdi-arrow-right-bold-box-outline' : undefined"
      :icons-and-text="icons"
      :height="65"
    >
      <!-- <v-tabs-slider></v-tabs-slider> -->

      <!-- <v-tab v-for="i in tabs" :key="i" :href="`#tab-${i}`">
        Tab {{ i }}
        <v-icon v-if="icons">Menu</v-icon>
      </v-tab>
      <v-tab-item v-for="i in tabs" :key="i" :value="'tab-' + i"></v-tab-item>-->

      <v-tab v-for="t in tabs" :key=t.id :to=t.route exact>{{ t.name }}</v-tab>
    </v-tabs>
  </div>
</template>

<script>
export default {
  name: "TabBar",


  data() {
    return {
      tab: null,

      icons: true,
      centered: true,
      grow: true,
      vertical: false,
      prevIcon: false,
      nextIcon: false,
      right: false,
      tabs: 5,

      tabs: [
        { id: 1, name: "NewsFeed", route: `/` },
        { id: 2, name: "Location", route: `/catList` },
        { id: 3, name: "AddPost", route: `/addpost` },
        { id: 4, name: "Search", route: `/login` },
        { id: 5, name: "TimeLine", route: `/user/${this.id}` }
      ]
    };
  }
};
</script>

