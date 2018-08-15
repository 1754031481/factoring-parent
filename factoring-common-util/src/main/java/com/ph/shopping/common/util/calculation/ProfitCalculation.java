package com.ph.shopping.common.util.calculation;


/**
 * 
 * @ClassName: ProfitCalculation
 * @Description: 管理费计算公式
 * @author WQiang
 * @date 2017年3月27日 下午2:34:33
 */
public class ProfitCalculation {
	/*********************************** 北京猎头分润 ****************************************/
	private static double D_13 = 0.13;// 13%
	private static double D_10 = 0.1;// 10%
	private static double D_0_3 = 0.003;// 0.3%
	private static double D_69 = 0.69;// 69%
	private static double D_0_5 = 0.005;// 0.5%
	private static double D_0_02 = 0.0002;// 0.02%
	private static double D_0_03 = 0.0003;// 0.03%

	private static double D_15 = 0.15;// 15%
	private static double D_7 = 0.07;// 7%
	private static double D_4_4 = 0.044;// 4.4%
	private static double D_2_2 = 0.022;// 2.2%

	/**
	 * 获取猎头分润
	 * @param a
	 * @param c
	 * @return
	 */
	public static double getB(double a, double c) {
		return (a - c);
	}

	/**
	 * 管理费
	 * @param a
	 * @return
	 */
	public static double getD(double a) {
		return (D_13 * a);
	}

	/**
	 * 普惠管理费
	 * @param a
	 * @return
	 */
	public static double getE(double a) {
		return (D_10 * a);
	}

	/**
	 * 易商通管理费
	 * @param a
	 * @return
	 */
	public static double getF(double a) {
		return (getD(a) - getE(a));
	}

	/**
	 * 市级代理分润
	 * @param a
	 * @return
	 */
	public static double getG(double a) {
		return (D_0_3 * D_69 * a);
	}

	/**
	 * 县级代理分润
	 * @param  a
	 * @return
	 */
	public static double getH(double a) {
		return (D_0_5 * D_69 * a);
	}

	/**
	 * 市级服务专员分润
	 * @param a
	 * @return
	 */
	public static double getK1(double a) {
		return (D_0_02 * a);
	}

	/**
	 * 县级服务专员分润
	 * @param a
	 * @return
	 */
	public static double getK2(double a) {
		return (D_0_03 * a);
	}

	// 管理费支出合计
//	public static double getP(double A) {
//		return (getG(A) + getH(A) + getK1(A) + getK2(A));
//	}

	// 管理费剩余
//	public static double getN(double A) {
//		return (getF(A) - getP(A));
//	}

	/**
	 * 供应链管理费
	 * @param a
	 * @return
	 */
	public static double getR(double a) {
		return (D_15 * a);
	}

	/**
	 * 普惠供应链收入
	 * @param a
	 * @return
	 */
	public static double getS(double a) {
		return (D_7 * a);
	}

	/**
	 * 易商通供应链收入
	 * @param a
	 * @return
	 */
	public static double getT(double a) {
		return (getR(a) - getS(a));
	}

	/**
	 * 市级代理分润
	 * @param a
	 * @return
	 */
	public static double getU(double a) {
		return (D_4_4 * D_69 * a);
	}

	/**
	 * 县级代理分润
	 * @param a
	 * @return
	 */
	public static double getW(double a) {
		return (D_2_2 * D_69 * a);
	}

	//供应链支出合计
//	public static double getY(double A) {
//		return (getU(A) + getW(A));
//	}
	//供应链剩余
//	public static double getQ(double A) {
//		return (getT(A) - getY(A));
//	}

	/***************************************** 北京猎头分润结束 ***************************************/
	/***************************************** 本地 ***************************************/
	
	private static int TEN = 10;
	private static int THIRTEEN = 13;
	
	private static double D_3_0 = 0.3;//30%
	private static double D_5_0 = 0.5;//50%
	private static double D_100 = 1;//100%
	private static double D_2 = 0.02;//2%
	private static double D_3 = 0.03;//3%
	private static double D_5 = 0.05;//5%
	
	// 获取13 * A
//	public static double get13A(double A) {
//		return (13 * A);
//	}

	/**
	 * 管理费
	 * @param x
	 * @param x
	 * @return
	 */
	public static double getChargeFee(double x, double a) {
		return (x * a);
	}

	/**
	 * 普惠管理费
	 * @param x
	 * @param a
	 * @return
	 */
	public static double getPhChargeFee(double x, double a) {
		return (x * TEN / THIRTEEN * a);
	}

	/**
	 * 易商通管理费
	 * @param x
	 * @param a
	 * @return
	 */
	public static double getYstChargeFee(double x, double a) {
		return (getChargeFee(x, a) - getPhChargeFee(x, a));
	}

	/**
	 * 市级代理分润
	 * @param x
	 * @param a
	 * @return
	 */
	public static double getCityAgency(double x, double a) {
		return (x * D_3_0 / THIRTEEN * D_69 * a);
	}

	/**
	 * 县级代理分润
	 * @param x
	 * @param a
	 * @return
	 */
	public static double getCountyAgency(double x, double a) {
		return (x * D_5_0 / THIRTEEN * D_69 * a);
	}

	/**
	 * 社区代理分润
	 * @param x
	 * @param a
	 * @return
	 */
	public static double getCommunityAgency(double x, double a) {
		return (x * D_100 / THIRTEEN * D_69 * a);
	}

	/**
	 * 服务专员推广市级代理分润
	 * @param x
	 * @param a
	 * @return
	 */
	public static double getRecommendCity(double x, double a) {
		return (x * D_2 / THIRTEEN * a);
	}

	/**
	 * 服务专员推广县级代理分润
	 * @param x
	 * @param a
	 * @return
	 */
	public static double getRecommendCounty(double x, double a) {
		return (x * D_3 / THIRTEEN * a);
	}

	/**
	 * 服务专员推广社区级代理分润
	 * @param x
	 * @param a
	 * @return
	 */
	public static double getRecommendCommunity(double x, double a) {
		return (x * D_5 / THIRTEEN * a);
	}

	/**
	 * 服务专员推广商户代理分润
	 * @param x
	 * @param a
	 * @return
	 */
	public static double getRecommendMerchant(double x, double a) {
		return (x * D_3_0 / THIRTEEN * a);
	}

	// 管理费支出合计
	/*public static double getChargeTotal(double x, double a) {
		System.out.println("市代理:" + getCityAgency(x, a));
		System.out.println("县代理:" + getCountyAgency(x, a));
		System.out.println("社区代理:" + getCommunityAgency(x, a));
		System.out.println("市代推荐:" + getRecommendCity(x, a));
		System.out.println("县代推荐:" + getRecommendCounty(x, a));
		System.out.println("社区代推荐:" + getRecommendCommunity(x, a));
		System.out.println("商户推荐:" + getRecommendMerchant(x, a));
		return (getCityAgency(x, a) + getCountyAgency(x, a) + getCommunityAgency(x, a)
				+ getRecommendCity(x, a) + getRecommendCounty(x, a) + getRecommendCommunity(x, a)
				+ getRecommendMerchant(x, a));
	}*/

	// 管理费剩余
	/*public static double getChargeRemain(double x, double a) {
		return (getYstChargeFee(x, a) - getChargeTotal(x, a));
	}*/

	
	/****************************管理费分润方法结束**************************************/
	public synchronized static double doubleFormat(double d) {
		
		return Double.parseDouble(String.format("%.2f", d));
	}
	
	public static void main(String[] args) {
		System.out.println(getD(10));
		System.out.println(getE(10));
		System.out.println(getF(10));
	}


	/**
	 * 零售价
	 * @param a
	 * @return
	 */
	public static double getPrice(double a) {
		return a;
	}

	/**
	 * 结算成本
	 * @param b
	 * @return
	 */
	public static double getCost(double b) {
		return b;
	}    

	/**
	 * 物流费用
	 * @param d
	 * @return
	 */
	public static double getLogisticsFee(double d) {
		return d;
	}

	/**
	 * 门店进货价
	 * @param a
	 * @return
	 */
	public static double getBuyExpense(double a) {
		return getPrice(a) * 0.61;
	}

	/**
	 * 供应链利润
	 * @param a
	 * @return
	 */
	public static double getChainProfit(double a) {
		return getPrice(a) * 0.15;
	}

	/**
	 * 普惠供应链收入
	 * @param a
	 * @return
	 */
	public static double getPhIncome(double a) {
		return getPrice(a) * 0.07;
	}

	/**
	 * 易商通供应链收入
	 * @param a
	 * @return
	 */
	public static double getYstIncome(double a) {
		return getPrice(a) * 0.08;
	}

	/**
	 * 市级代理分润
	 * @param a
	 * @return
	 */
	public static double getCityProfit(double a) {
		return getPrice(a) * 0.044 * 0.69;
	}

	/**
	 * 县级代理分润
	 * @param a
	 * @return
	 */
	public static double getCountyProfit(double a) {
		return getPrice(a) * 0.022 * 0.69;
	}

	/**
	 * 社区代理分润
	 * @param a
	 * @return
	 */
	public static double getCommunityProfit(double a) {
		return getPrice(a) * 0.014 * 0.69;
	}

	/**
	 * 供应链支出合计
	 * @param a
	 * @return
	 */
	public static double getChainTotal(double a) {
		return getPrice(a) * (0.044 * 0.69 + 0.022 * 0.69 + 0.014 * 0.69);
	}

	/**
	 * 供应链剩余
	 * @param a
	 * @return
	 */
	public static double getChainRemain(double a) {
		return getPrice(a) * (0.15 - 0.07 - 0.044 * 0.69 - 0.022 * 0.69 - 0.014 * 0.69);
	}

	/**
	 * 易商通总余
	 * @param a
	 * @param b
	 * @param d
	 * @return
	 */
	public static double getYstRemain(double a, double b, double d) {
		return getPrice(a) * 0.61 - b - d - 0.044 * 0.69 * getPrice(a) - 0.022 * 0.69 * getPrice(a)
				- 0.014 * 0.69 * getPrice(a) - 0.07 * getPrice(a);
	}

	/**
	 * 普惠总余
	 * @param a
	 * @return
	 */
	public static double getPhRemain(double a) {
		return getPrice(a) * 0.07;
	}
}
