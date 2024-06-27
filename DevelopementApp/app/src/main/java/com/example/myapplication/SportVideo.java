package com.example.myapplication;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adapter.VideoAdapter;
import com.example.api.VideoService;
import com.example.model.Video;
import com.example.model.VideoResponse;
import com.example.myapplication.databinding.SportvideoBinding;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SportVideo extends AppCompatActivity {

    private SportvideoBinding binding;
    private VideoAdapter videoAdapter;
    private List<Video> videoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = SportvideoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bmiBack.setOnClickListener(v -> onBackPressed());

        // Initialize the RecyclerView
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        videoAdapter = new VideoAdapter(this, videoList);
        binding.recyclerView.setAdapter(videoAdapter);

        // Fetch video data
        fetchVideoData();
    }

    private void fetchVideoData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apis.juhe.cn/fapig/douyin/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VideoService videoService = retrofit.create(VideoService.class);

        videoService.getVideoList("YOUR_API_KEY").enqueue(new Callback<VideoResponse>() {
            @Override
            public void onResponse(Call<VideoResponse> call, Response<VideoResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Video> videos = response.body().getResult();
                    if (videos != null && !videos.isEmpty()) {
                        // Update the data list and notify the adapter
                        videoList.clear();
                        videoList.addAll(videos);
                        videoAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(SportVideo.this, "No videos found", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SportVideo.this, "Failed to load videos", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<VideoResponse> call, Throwable t) {
                Toast.makeText(SportVideo.this, "Request failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
