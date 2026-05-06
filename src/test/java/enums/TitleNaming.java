package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TitleNaming {
    PRODUCTS("Products"),
    CART("Your Cart"),
    CHECKOUT_STEP_ONE("Checkout: Your Information"),
    CHECKOUTS("Checkout: Overview"),
    CHECKOUT_COMPLETE("Checkout: Complete!");

    private final String displayName;
}
