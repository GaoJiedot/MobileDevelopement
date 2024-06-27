package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.api.BMIService;
import com.example.model.BMIResponse;
import com.example.myapplication.R;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BMI extends AppCompatActivity {

    private EditText heightEditText;
    private EditText weightEditText;
    private Button bmiButton;
    private TextView resultTextView;
    private BMIService bMIService;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);

        heightEditText = findViewById(R.id.height_et);
        weightEditText = findViewById(R.id.weight_et);
        bmiButton = findViewById(R.id.BMI_button);
        resultTextView = findViewById(R.id.bmi_tv);
        imageView =findViewById(R.id.bmi_back);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apis.juhe.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        bMIService = retrofit.create(BMIService.class);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bmiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchWeightData("4f7273a9591807055149c33cfeb067c7");
            }
        });
    }

    private void fetchWeightData(String apiKey) {
        String heightStr = heightEditText.getText().toString().trim();
        String weightStr = weightEditText.getText().toString().trim();

        if (!heightStr.isEmpty() && !weightStr.isEmpty()) {
            try {
                int height = Integer.parseInt(heightStr);
                int weight = Integer.parseInt(weightStr);

                Call<BMIResponse> call = bMIService.getWeightData(apiKey, height, weight);
                call.enqueue(new Callback<BMIResponse>() {
                    @Override
                    public void onResponse(Call<BMIResponse> call, Response<BMIResponse> response) {
                        if (response.isSuccessful()) {
                            BMIResponse bmiResponse = response.body();
                            if (bmiResponse != null && bmiResponse.getResult() != null) {
                                StringBuilder result = new StringBuilder();
                                BMIResponse.Result resultData = bmiResponse.getResult();

                                result.append("BMI: ").append(String.format("%.1f", resultData.getBmi())).append("\n")
                                        .append("理想体重: ").append(String.format("%.1f", resultData.getIdealWeight())).append("kg\n")
                                        .append("正常体重范围: ").append(resultData.getNormalWeight()).append("\n")
                                        .append("体质指数等级: ").append(resultData.getLevelMsg()).append("\n")
                                        .append("危险等级: ").append(resultData.getDanger()).append("\n")
                                        .append("正常BMI范围: ").append(resultData.getNormalBMI());

                                resultTextView.setText(result.toString());
                                Log.d("API Response", result.toString());
                            } else {
                                Log.e("API Error", "Result is null");
                                resultTextView.setText("API响应无效");
                            }
                        } else {
                            Log.e("API Error", "Response not successful");
                            resultTextView.setText("API调用失败");
                        }
                    }

                    @Override
                    public void onFailure(Call<BMIResponse> call, Throwable t) {
                        Log.e("API Error", "Network request failed", t);
                        resultTextView.setText("网络请求失败");
                    }
                });

            } catch (NumberFormatException e) {
                Toast.makeText(BMI.this, "请输入有效的身高和体重", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(BMI.this, "请输入身高和体重", Toast.LENGTH_SHORT).show();
        }
    }
}
