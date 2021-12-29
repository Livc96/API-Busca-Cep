package com.example.BuscaCEP.ws;

import com.example.BuscaCEP.model.Endereco;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.json.Json;
import javax.json.JsonObject;
import org.apache.http.impl.client.DefaultHttpClient;

@Component
public class BuscaCepWs {

    private static final Logger LOG = LoggerFactory.getLogger(BuscaCepWs.class);

    /**
     * Realiza uma requisição ao serviço da microsoft de solicitação do Token de acesso ao painel.
     *
     //* @param Cep cep (obrigatório)
     */
    public static Endereco getCep(String cep) {

        try {

            JsonObject jsonObject = getZipCodeResponse(cep);

            Endereco endereco = new Endereco(jsonObject.getString("cep"),
                    jsonObject.getString("logradouro"),
                    jsonObject.getString("complemento"),
                    jsonObject.getString("bairro"),
                    jsonObject.getString("localidade"),
                    jsonObject.getString("uf"),
                    jsonObject.getString("unidade"),
                    jsonObject.getString("ibge"),
                    jsonObject.getString("gia")
            );

            return endereco;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static JsonObject getZipCodeResponse(String cep) {

        JsonObject responseJO;

        try {
            if (!cep.matches("\\d{8}")) {
                throw new RuntimeException("Invalid CEP");
            }

            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet("https://viacep.com.br/ws/"+cep+"/json");
            HttpResponse response = (HttpResponse) httpclient.execute(httpGet);

            HttpEntity entity = response.getEntity();

            responseJO = Json.createReader(entity.getContent()).readObject();

        } catch (Exception e) {

            throw new RuntimeException(e);
        }

        return responseJO;
/*
            JACKSON
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://viacep.com.br/ws/"+cep+"/json")
                    .build();
            ObjectMapper objectMapper = new ObjectMapper();
            ResponseBody responseBody = client.newCall(request).execute().body();
*/
    }





    }
//        okhttp3.ResponseBody responseBody = null;
//        try {
//            RequestBody formBody = new FormBody.Builder()
//                    .addEncoded("cep","06150610")
//                    .build();
//
//            Request request = new Request.Builder()
//                    .url("https://viacep.com.br/ws/"+cep+"/json")
//                    .post(formBody)
//                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
//                    .build();
//
//            Response response = getUnsafeOkHttpClient()
//                    .newBuilder()
//                    .build().newCall(request).execute();
//            if (response.isSuccessful()) {
//                responseBody = (ResponseBody) response.body();
//
//                JSONObject responseJson = new JSONObject(responseBody.string());
//                if (responseJson.has("access_token")) {
//                    return responseJson.getString("access_token");
//                }
//
//                throw new Exception(response.message());
//            }
//        } catch (Exception e) {
//            LOG.error("[WS POWER BI] Não foi possível gerar o token para acesso ao painel do Power BI", e);
//        } finally {
//            if (responseBody != null) {
//                responseBody.close();
//            }
//        }
//        return null;
//    }
//
//    private static OkHttpClient getUnsafeOkHttpClient() {
//        try {
//            // Create a trust manager that does not validate certificate chains
//            final TrustManager[] trustAllCerts = new TrustManager[]{
//                    new X509TrustManager() {
//                        @Override
//                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain,
//                                                       String authType) throws CertificateException {
//                        }
//
//                        @Override
//                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain,
//                                                       String authType) throws CertificateException {
//                        }
//
//                        @Override
//                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//                            return new X509Certificate[0];
//                        }
//                    }
//            };
//
//            // Install the all-trusting trust manager
//            final SSLContext sslContext = SSLContext.getInstance("SSL");
//            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
//            // Create an ssl socket factory with our all-trusting manager
//            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
//
//            return new OkHttpClient.Builder()
//                    .sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0])
//                    .hostnameVerifier(new HostnameVerifier() {
//                        @Override
//                        public boolean verify(String hostname, SSLSession session) {
//                            return true;
//                        }
//                    }).build();
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
