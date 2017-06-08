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
public class UsuarioRequester {

    OkHttpClient client = new OkHttpClient();

    public ArrayList<Usuario> get(String url, String chave) throws IOException {
        ArrayList<Usuario> lista = new ArrayList<>();

        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute(); //error aqui
        String jsonString = response.body().string();
        try {
            JSONArray root = new JSONArray(jsonString);

            for (int i = 0; i < root.length(); i++) {
               JSONObject item = root.getJSONObject(i);
                int id = item.getInt("id");
                String email = item.getString("email");
                String senha = item.getString("senha");
                String tipo = item.getString("tipo");
                Usuario usuario = new Usuario(id, email, senha, tipo);
                lista.add(usuario);
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
