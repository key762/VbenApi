# Vben Admin 的Java后端项目-Flyway支持多种数据库

- 支持多种数据库类型
- 下载后简单配置即用

### 使用教程 (Vben Admin Ele)
``需要改动apps/web-ele/src/api/request.ts文件的两个地方``
```js
// response数据解构
  client.addResponseInterceptor<HttpResponse>({
    fulfilled: (response) => {
      const { data: responseData, status } = response;

      const { code, data, message: msg } = responseData;
      if (status >= 200 && status < 400 && code === 0) {
        return data;
      } else if (status >= 200 && status < 400 && code !== 0) {
        return Promise.reject(response);
      }
      throw new Error(`Error ${status}: ${msg}`);
    },
  });
```


```js
  // 通用的错误处理,如果没有进入上面的错误处理逻辑，就会进入这里
  client.addResponseInterceptor(
    errorMessageResponseInterceptor((msg: string, error) => {
      // 这里可以根据业务进行定制,你可以拿到 error 内的信息进行定制化处理，根据不同的 code 做不同的提示，而不是直接使用 message.error 提示 msg
      // 当前mock接口返回的错误字段是 error 或者 message
      if (error?.data?.code !== 0) {
        ElMessage.error(error?.data?.msg);
      } else {
        const responseData = error?.response?.data ?? {};
        const errorMessage = responseData?.error ?? responseData?.message ?? '';
        // 如果没有错误信息，则会根据状态码进行提示
        ElMessage.error(errorMessage || msg);
      }
    }),
  );
```

``需要改动apps/web-ele/vite.config.mts文件的请求地址``
```js
import { defineConfig } from '@vben/vite-config';

import ElementPlus from 'unplugin-element-plus/vite';

export default defineConfig(async () => {
    return {
        application: {},
        vite: {
            plugins: [
                ElementPlus({
                    format: 'esm',
                }),
            ],
            server: {
                proxy: {
                    '/api': {
                        changeOrigin: true,
                        rewrite: (path) => path.replace(/^\/api/, ''),
                        // mock代理目标地址
                        // target: 'http://localhost:5320/api',
                        // VbenApi地址
                        target: 'http://localhost:8067/api',
                        ws: true,
                    },
                },
            },
        },
    };
});
```

``需要关闭apps/web-ele/.env.development的Nitro Mock服务``
```properties
# 端口号
VITE_PORT=5777

VITE_BASE=/

# 接口地址
VITE_GLOB_API_URL=/api

# 是否开启 Nitro Mock服务，true 为开启，false 为关闭
VITE_NITRO_MOCK=false

# 是否打开 devtools，true 为打开，false 为关闭
VITE_DEVTOOLS=false

# 是否注入全局loading
VITE_INJECT_APP_LOADING=true
```