package vo;

public class Information {
	private String orderNum;			//订单顺序号
	private String EMSTrackNum;			//EMS物流单号
	private double pureWeight;			//净重
	private double roughWeight;			//毛重
	private double number;				//件数
	private String mainGoods;			//主要商品
	private String receiName;			//接收人姓名
	private String receiProvinCode;		//收件人省市区代码
	private String receiAddr;			//收件人地址
	private String receiTel;			//收件人电话
	private String consignerName;		//发货人名称
	private String consignerProvinCode;	//发货人省市区代码
	private String consignerAddr;		//发货人地址
	private String consignerTel;		//发货人电话
	private String note;				//备注
	
	//生成get，set方法
	
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getEMSTrackNum() {
		return EMSTrackNum;
	}
	public void setEMSTrackNum(String eMSTrackNum) {
		EMSTrackNum = eMSTrackNum;
	}
	public double getPureWeight() {
		return pureWeight;
	}
	public void setPureWeight(double pureWeight) {
		this.pureWeight = pureWeight;
	}
	public double getRoughWeight() {
		return roughWeight;
	}
	public void setRoughWeight(double roughWeight) {
		this.roughWeight = roughWeight;
	}
	public double getNumber() {
		return number;
	}
	public void setNumber(double number) {
		this.number = number;
	}
	public String getMainGoods() {
		return mainGoods;
	}
	public void setMainGoods(String mainGoods) {
		this.mainGoods = mainGoods;
	}
	public String getReceiName() {
		return receiName;
	}
	public void setReceiName(String receiName) {
		this.receiName = receiName;
	}
	public String getReceiProvinCode() {
		return receiProvinCode;
	}
	public void setReceiProvinCode(String receiProvinCode) {
		this.receiProvinCode = receiProvinCode;
	}
	public String getReceiAddr() {
		return receiAddr;
	}
	public void setReceiAddr(String receiAddr) {
		this.receiAddr = receiAddr;
	}
	public String getReceiTel() {
		return receiTel;
	}
	public void setReceiTel(String receiTel) {
		this.receiTel = receiTel;
	}
	public String getConsignerName() {
		return consignerName;
	}
	public void setConsignerName(String consignerName) {
		this.consignerName = consignerName;
	}
	public String getConsignerProvinCode() {
		return consignerProvinCode;
	}
	public void setConsignerProvinCode(String consignerProvinCode) {
		this.consignerProvinCode = consignerProvinCode;
	}
	public String getConsignerAddr() {
		return consignerAddr;
	}
	public void setConsignerAddr(String consignerAddr) {
		this.consignerAddr = consignerAddr;
	}
	public String getConsignerTel() {
		return consignerTel;
	}
	public void setConsignerTel(String consignerTel) {
		this.consignerTel = consignerTel;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	//生成构造方法
	public Information(String orderNum, String eMSTrackNum, double pureWeight, double roughWeight, double number,
			String mainGoods, String receiName, String receiProvinCode, String receiAddr, String receiTel,
			String consignerName, String consignerProvinCode, String consignerAddr, String consignerTel, String note) {
		super();
		this.orderNum = orderNum;
		EMSTrackNum = eMSTrackNum;
		this.pureWeight = pureWeight;
		this.roughWeight = roughWeight;
		this.number = number;
		this.mainGoods = mainGoods;
		this.receiName = receiName;
		this.receiProvinCode = receiProvinCode;
		this.receiAddr = receiAddr;
		this.receiTel = receiTel;
		this.consignerName = consignerName;
		this.consignerProvinCode = consignerProvinCode;
		this.consignerAddr = consignerAddr;
		this.consignerTel = consignerTel;
		this.note = note;
	}
	public Information() {
		super();
	}
	public Information(double roughWeight,double number,String mainGoods) {
		this.roughWeight=roughWeight;
		this.number=number;
		this.mainGoods=mainGoods;
	}
	//生成toString 方法
	@Override
	public String toString() {
		return "Information [orderNum=" + orderNum + ", EMSTrackNum=" + EMSTrackNum + ", pureWeight=" + pureWeight
				+ ", roughWeight=" + roughWeight + ", number=" + number + ", mainGoods=" + mainGoods + ", receiName="
				+ receiName + ", receiProvinCode=" + receiProvinCode + ", receiAddr=" + receiAddr + ", receiTel="
				+ receiTel + ", consignerName=" + consignerName + ", consignerProvinCode=" + consignerProvinCode
				+ ", consignerAddr=" + consignerAddr + ", consignerTel=" + consignerTel + ", note=" + note + "]\n";
	}
}
