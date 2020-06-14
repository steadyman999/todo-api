# todo-api
* Spring Boot Initializer

# frontend
- Vuejs 프로젝트 생성
  - `vue create frontend`
- dev server proxy 설정
  - frontend/vue.config.js 추가
    ```
    module.exports = {가
      devServer: {
        proxy: {
          '/api': {
            target: 'http://localhost:8000',
            ws: true,
            changeOrigin: true,
          },
        },
      },
      transpileDependencies: [
        'vuetify',
      ],
    };
    ```
- Vuetify 추
  - `vue add vutify`