package com.book.store.utill;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonInclude;

public class BookUtill {

	/**
	 * @author Syyed Sheeraz Shaukat
	 * 
	 * 
	 */

	public static double calculateDiscount(String bookType) {
		double appliedDiscount;
		switch (bookType) {
		case DiscountConstant.TYPE_COMIC:
			appliedDiscount = DiscountConstant.ZERO_PERCENT;
			break;
		case DiscountConstant.TYPE_FICTION:
			appliedDiscount = DiscountConstant.FIFTEEN;
			break;
		case DiscountConstant.TYPE_NON_FICTION:
			appliedDiscount = DiscountConstant.FIVE_PERCENT;
			break;
		case DiscountConstant.TYPE_TECHNICAL:
			appliedDiscount = DiscountConstant.TWENTY_FIVE;
			break;
		case DiscountConstant.TYPE_NOVEL:
			appliedDiscount = DiscountConstant.TEN_PERCENT;
			break;
		default:
			appliedDiscount = DiscountConstant.ZERO_PERCENT;
		}
		return appliedDiscount;
	}

	public static Double calculateDiscountForPromoCode(String promoCode) {
		double appliedDiscount;
		switch (promoCode) {
		case DiscountConstant.FIRST_TIME_USER_PROMO:
			appliedDiscount = DiscountConstant.TEN_PERCENT;
			break;
		case DiscountConstant.STUDENT_PROMO:
			appliedDiscount = DiscountConstant.FIFTEEN;
			break;
		case DiscountConstant.DEFAULT_PROMO:
			appliedDiscount = DiscountConstant.FIVE_PERCENT;
		default:
			appliedDiscount = DiscountConstant.ZERO_PERCENT;
		}
		return appliedDiscount;
	}

	public static Double getPriceForDicnt(Double price, Double percentage) {

		if (percentage > 0.0 && percentage < 100.0) {
			if (price > 0.0) {
				price = (price * (100 - percentage)) / 100;
			}
		}

		return price;
	}

	 public static byte[] toJson(Object object) throws IOException {
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	        return mapper.writeValueAsBytes(object);
	    }
	
	
}
