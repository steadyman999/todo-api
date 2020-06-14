<template>
  <v-app>
    <TopBar/>
    <v-main>
      <ContentContainer/>
    </v-main>
    <BottomNav/>
  </v-app>
</template>

<script>
import TopBar from './components/TopBar.vue';
import ContentContainer from './components/ContentContainer.vue';
import BottomNav from './components/BottomNav.vue';

export default {
  name: 'App',

  components: {
    TopBar,
    ContentContainer,
    BottomNav,
  },

  data: () => ({
    //
  }),
};
</script>
