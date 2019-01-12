package com.vaadin.starter.skeleton;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;


@Route(value = "edit")
public class PopupEditor extends Dialog implements RouterLayout {

    private ComboBox<Currency> positionCurrency = new ComboBox<>("Валюта позиции");
    private ComboBox<Currency> positionCloseCurrency = new ComboBox<>("Валюта закрытия позиции");
    private HorizontalLayout currencyRow;

    public PopupEditor() {
        initCommonCurrencyComboBox(positionCurrency, true);
        initCommonCurrencyComboBox(positionCloseCurrency, false);

        currencyRow = new HorizontalLayout(positionCurrency, positionCloseCurrency);
        currencyRow.setWidth("100%");
        add(currencyRow);
    }

    private void initCommonCurrencyComboBox(ComboBox<Currency> combo, boolean required) {
        combo.setItems(Currency.values());
        combo.setRequired(required);
        combo.setWidth("50%");
        combo.setItemLabelGenerator(this::getCurrencyLabel);
        combo.setAllowCustomValue(true);
    }

    private String getCurrencyLabel(Currency item) {
        return item.name() + " (" + item.toString() + ")";
    }

}
