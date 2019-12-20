package com.pavlekuzevski.weatherapp.ui.report;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.pavlekuzevski.weatherapp.data.model.DarkSky.ForecastData;
import com.pavlekuzevski.weatherapp.databinding.ItemReportBinding;
import com.pavlekuzevski.weatherapp.ui.base.BaseViewHolder;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class ReportListAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<ForecastData> forecastItems;

    public ReportListAdapter(List<ForecastData> forecastItems) {
        this.forecastItems = forecastItems;
    }

    @Override
    public int getItemCount() {
        return forecastItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    public void addItems(List<ForecastData> items) {
        forecastItems.addAll(items);
        notifyDataSetChanged();
    }

    public void clearItems() {
        forecastItems.clear();
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemReportBinding itemReportBinding = ItemReportBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new ReportViewHolder(itemReportBinding);
    }

    public class ReportViewHolder extends BaseViewHolder {

        private ItemReportBinding binding;

        private ReportItemViewModel viewModel;

        public ReportViewHolder(ItemReportBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @Override
        public void onBind(int position) {
            final ForecastData data = forecastItems.get(position);
            viewModel = new ReportItemViewModel(data);
            binding.setViewModel(viewModel);

            // Immediate Binding
            // When a variable or observable changes, the binding will be scheduled to change before
            // the next frame. There are times, however, when binding must be executed immediately.
            // To force execution, use the executePendingBindings() method.
            binding.executePendingBindings();
        }
    }
}


