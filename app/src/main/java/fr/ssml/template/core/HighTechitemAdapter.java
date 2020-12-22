package fr.ssml.template.core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fr.ssml.template.R;

public class HighTechitemAdapter extends BaseAdapter {

    private Context context;
    private List<HighTechItem> highTechItemList;
    private LayoutInflater inflater;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<HighTechItem> getHighTechItemList() {
        return highTechItemList;
    }

    public void setHighTechItemList(List<HighTechItem> highTechItemList) {
        this.highTechItemList = highTechItemList;
    }

    public HighTechitemAdapter(Context context, List<HighTechItem> highTechItemList) {
        this.context = context;
        this.highTechItemList = highTechItemList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return highTechItemList.size();
    }

    @Override
    public HighTechItem getItem(int position) {
        return highTechItemList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.layout_chapitre10, null);
        // view = inflater.inflate(R.layout.layout_chapitre10, viewGroup);
        HighTechItem currentItem = getItem(i);
        String itemName = currentItem.getNam();
        String mnemonic = currentItem.getMnemonic();
        double itemPrice = currentItem.getPrice();

        ImageView itemIconView = view.findViewById(R.id.itemIcon);
        String resourceName = mnemonic;
        int resId = context.getResources().getIdentifier(resourceName, "drawable", context.getPackageName());
        itemIconView.setImageResource(resId);

        TextView itemNameView = view.findViewById(R.id.item_name);
        itemNameView.setText(itemName);

        TextView itemPriceView = view.findViewById(R.id.item_price);
        itemPriceView.setText(itemPrice + "euros");
        return view;
    }
}
