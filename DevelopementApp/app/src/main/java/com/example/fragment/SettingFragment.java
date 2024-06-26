    package com.example.fragment;

    import android.content.Intent;
    import android.os.Bundle;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;

    import androidx.annotation.NonNull;
    import androidx.annotation.Nullable;
    import androidx.fragment.app.Fragment;

    import com.example.myapplication.R;
    import com.example.myapplication.Setting;
    import com.example.myapplication.databinding.SettingBinding;

    public class SettingFragment extends Fragment {
        private SettingBinding binding;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            binding = SettingBinding.inflate(getLayoutInflater());

          binding.jksj.setOnClickListener(v -> navigateToFragment(new BodyDataFragment()));
          binding.stsjSet.setOnClickListener(v -> navigateToFragment(new BodyDataFragment()));
            binding.sz.setOnClickListener(v -> startActivity(new Intent(getActivity(), Setting.class)));

            return binding.getRoot();


        }



        private void navigateToFragment(Fragment fragment) {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fg, fragment)
                    .addToBackStack(null)
                    .commit();

        }
    }
