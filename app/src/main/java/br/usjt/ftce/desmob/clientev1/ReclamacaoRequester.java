package br.usjt.ftce.desmob.clientev1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by arqdsis on 31/03/2017.
 */
public class ReclamacaoRequester {

    OkHttpClient client = new OkHttpClient();

    public ArrayList<Reclamacao> get(String url, String chave) throws IOException {
        ArrayList<Reclamacao> lista = new ArrayList<>();

        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute(); //error aqui
        String jsonString = response.body().string();
        try {
            JSONArray root = new JSONArray(jsonString);

            for (int i = 0; i < root.length(); i++) {
               JSONObject item = root.getJSONObject(i);
                int id = item.getInt("id");
                String nome = item.getJSONObject("cidadao").getString("nome");
                String titulo = item.getString("titulo");
                String descricao = item.getString("descricao");
                Reclamacao reclamacao = new Reclamacao(id, nome, titulo, descricao);
                lista.add(reclamacao);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println( Arrays.toString(lista.toArray()));
        return lista;
    }

    public Bitmap getImage(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        InputStream is = response.body().byteStream();
        Bitmap img = BitmapFactory.decodeStream(is);
        is.close();

        return img;
    }

    public boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();

    }
}
