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