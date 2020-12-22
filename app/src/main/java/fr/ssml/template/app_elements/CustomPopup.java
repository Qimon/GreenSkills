package fr.ssml.template.app_elements;

import android.app.Activity;
import android.app.Dialog;
import android.widget.Button;
import android.widget.TextView;
import fr.ssml.template.R;

public class CustomPopup extends Dialog {

    // Initialisation des éléments de la vue
    private String title;
    private String subtitle;
    private Button yesButton, noButton;
    private TextView titleView, subTitleView;

    public CustomPopup(Activity activity){
        super(activity, R.style.Theme_AppCompat_Dialog_MinWidth);
        setContentView(R.layout.my_popup_template);

        this.title = "Titre Par défaut";
        this.subtitle = "Sous-Titre Par Défaut";
        this.yesButton = findViewById(R.id.Oui);
        this.noButton = findViewById(R.id.Non);
        this.titleView = findViewById(R.id.title);
        this.subTitleView = findViewById(R.id.subtitle);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public Button getYesButton() {
        return yesButton;
    }

    public void setYesButton(Button yesButton) {
        this.yesButton = yesButton;
    }

    public Button getNoButton() {
        return noButton;
    }

    public void setNoButton(Button noButton) {
        this.noButton = noButton;
    }

    public TextView getTitleView() {
        return titleView;
    }

    public void setTitleView(TextView titleView) {
        this.titleView = titleView;
    }

    public TextView getSubTitleView() {
        return subTitleView;
    }

    public void setSubTitleView(TextView subTitleView) {
        this.subTitleView = subTitleView;
    }

    @Override
    public String toString() {
        return "CustomPopup{" +
                "title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", yesButton=" + yesButton +
                ", noButton=" + noButton +
                ", titleView=" + titleView +
                ", subTitleView=" + subTitleView +
                '}';
    }

    public void build() {
        show();
        titleView.setText(title);
        subTitleView.setText(subtitle);
    }
}
