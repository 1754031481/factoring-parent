/**  
 * @Title:  SmsDataService.java   
 * @Package com.ph.shopping.common.core.other.sms.handle   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 李杰    
 * @date:   2017年5月15日 下午11:20:36   
 * @version V1.0 
 * @Copyright: 2017
 */  
package com.ph.shopping.common.core.other.sms.handle;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ph.shopping.common.core.cache.redis.ICacheService;
import com.ph.shopping.common.core.config.SmsConfig;
import com.ph.shopping.common.core.customenum.SmsCodeType;
import com.ph.shopping.common.core.customenum.SmsSourceEnum;
import com.ph.shopping.common.core.dto.CheckDTO;
import com.ph.shopping.common.core.dto.FindPasswordDTO;
import com.ph.shopping.common.core.other.sms.YunPianSmsSendService;
import com.ph.shopping.common.core.other.sms.data.SmsSendData;
import com.ph.shopping.common.core.other.sms.senum.SmsStatusEnum;
import com.ph.shopping.common.core.util.SmsUtil;
import com.ph.shopping.common.util.container.ParamVerifyUtil;
import com.ph.shopping.common.util.core.RespCode;
import com.ph.shopping.common.util.core.ResultUtil;
import com.ph.shopping.common.util.result.Result;
import org.alqframework.net.html.HttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @ClassName: SmsDataService
 * @Description: 短信发送服务  
 * @author liuy
 * @date 2017年6月1日 上午11:44:04
 */
@Service
@SuppressWarnings("unchecked")
public class SmsDataServiceImpl implements ISmsDataService{

	Logger logger = LoggerFactory.getLogger(SmsDataServiceImpl.class);

	@Autowired
	private @SuppressWarnings("rawtypes") ICacheService redisService;
	
	// yunpian 短信发送服务
	@Autowired
	private YunPianSmsSendService yunPianSmsSendService;
	@Autowired
	private SmsUtil smsUtil;
    @Autowired
    private SmsConfig smsConfig;

	@Override
	public Result sendSmsHaveCode(SmsSendData sendData) {
		final String one = "1";
		final String two = "2";
		Result result = ResultUtil.getResult(SmsStatusEnum.PARAM_INCOMPLETE);
		FindPasswordDTO findPasswordDTO = new FindPasswordDTO();
		// 验证短信发送参数
		/*if (!sendDataVerify(sendData)) {
			return result;
		}*/
		// 封装数据
		final SmsCodeType type = sendData.getType();
		final String mobile = sendData.getMobile();
		final String mobileType = (String) sendData.getModelData();
		//final SmsSourceEnum smsSourceEnum = sendData.getSourceEnum();
		//final String smsCode = sendData.getSmsCode();
		
		if(null==type ||null==mobile || "".equals(mobile)){
			result = ResultUtil.getResult(SmsStatusEnum.PARAM_INCOMPLETE);
			return result;
		}
		
		boolean exists = SmsCodeType.isExists(type);
		if(!exists){
			result = ResultUtil.getResult(SmsStatusEnum.FORMAL_ERROR);
			return result;
		}
		
		findPasswordDTO.setPhone(mobile);
		findPasswordDTO.setCodeType("Fr170001");
		String yTime = 1+"";
		findPasswordDTO.setYTime(yTime);
		//客服电话：400–8586–315
		findPasswordDTO.setKfPhone("400–8586–315");
		//完善短信模板
		if(one.equals(mobileType)){
			findPasswordDTO.setOperation("注册");
		}
		if(two.equals(mobileType)){
			findPasswordDTO.setOperation("找回密码");
		}
		findPasswordDTO.setOperation(sendData.getType().getDesc());

		// 发送短信
		//result = yunPianSmsSendService.sendSmsHaveCode(mobile, smsCode, smsSourceEnum, type);
		boolean sendRegisterOrFindPasswordMsg = smsUtil.sendRegisterOrFindPasswordMsg(findPasswordDTO);
		// 设置缓存
		//if (result.isSuccess()) {
		if(sendRegisterOrFindPasswordMsg){
			// 判断是否需要缓存，发送验证码需要缓存。这里借用“找回密码”验证码枚举是否缓存为0的值来判断
			/*if (type.getIsCache().equals(SmsCodeType.BACK_USER_PWD_VC.getIsCache())) {
				redisService.set(getSmsKey(mobile, type.getCodeType(), sendData.getSourceEnum()), smsCode,
						CacheConfigEnum.SMS_MAX_TIME.getDuration(), CacheConfigEnum.SMS_MAX_TIME.getUnit());
			}*/
			ResultUtil.setResult(result, RespCode.Code.SUCCESS);
			
		}else{
			result = ResultUtil.getResult(SmsStatusEnum.VERIFYCODE_FAIL);
			return result;
		}
		return result;
		
	}

	@Override
	public Result sendSmsNoCode(SmsSendData sendData) {
		Result result = ResultUtil.getResult(SmsStatusEnum.PARAM_INCOMPLETE);
		// 验证短信发送参数
		if (!sendDataVerifyNoCode(sendData)) {
			return result;
		}
		// 封装数据
		final SmsCodeType type = sendData.getType();
		final SmsSourceEnum smsSourceEnum = sendData.getSourceEnum();
		final String mobile = sendData.getMobile();
		// 发送短信
		result = yunPianSmsSendService.sendSmsNoCode(mobile, smsSourceEnum, type);
		return result;
	}
	
	@Override
	public Result sendSmsByCustomModelData(SmsSendData sendData) {
		Result result = ResultUtil.getResult(SmsStatusEnum.PARAM_INCOMPLETE);
		if (!sendDataVerifyCustomModel(sendData)) {
			return result;
		}
		// 发送短信
		return yunPianSmsSendService.sendSmsByModelData(sendData.getMobile(), sendData.getModelData(),
				sendData.getType());
	}
	
	@Override
	public Result checkSmsCodeByMobile(SmsSendData sendData) {
		Result result = ResultUtil.getResult(SmsStatusEnum.PARAM_INCOMPLETE);
		/*if (!sendDataVerify(sendData)) {
			return result;
		}*/
		final SmsCodeType type = sendData.getType();
		final String mobile = sendData.getMobile();
		final String smsCode = sendData.getSmsCode();
		//Object obj = redisService.get(getSmsKey(mobile, type.getCodeType(), sendData.getSourceEnum()));
		CheckDTO checkDTO = new CheckDTO();
		checkDTO.setPhone(mobile);
		checkDTO.setCodeType("Fr170001");
		checkDTO.setCode(smsCode);
		
		boolean check = smsUtil.check(checkDTO);
		
		if(check){
			ResultUtil.setResult(result, RespCode.Code.SUCCESS);
		}else{
			ResultUtil.setResult(result, SmsStatusEnum.SMS_ERROR);
		}
		
		/*if (obj == null) {
			ResultUtil.setResult(result, SmsStatusEnum.SMS_LOSE);
		} else if (obj.toString().equals(smsCode)) {
			ResultUtil.setResult(result, RespCode.Code.SUCCESS);
		} else {
			ResultUtil.setResult(result, SmsStatusEnum.SMS_ERROR);
		}*/
		return result;
	}
	/**
	 * 
	 * @Title: getSmsKey   
	 * @Description: 根据手机号类型得到 sms key   
	 * @param: @param mobile
	 * @param: @param type
	 * @param: @return      
	 * @return: String
	 * @author：李杰      
	 * @throws
	 */
	private static String getSmsKey(String mobile, String type, SmsSourceEnum sourceEnum) {
		StringBuilder bud = new StringBuilder(sourceEnum.name())
				.append("_").append(mobile).append("_").append(type);
		return bud.toString();
	}
	/**
	 * 
	 * @Title: sendDataVerify
	 * @Description:非空验证   
	 * @param: @param sendData
	 * @param: @return      
	 * @return: boolean
	 * @author：李杰      
	 * @throws
	 */
	private static boolean sendDataVerify(SmsSendData sendData) {
		String[] fields = { "mobile", "type", "smsCode" };
		return ParamVerifyUtil.entityIsNotNullByField(sendData, fields);
	}
	
	/**
	 * 
	 * @Title: sendDataVerifyNoCode
	 * @Description: 非空验证（无验证码的校验）
	 * @author liuy
	 * @date  2017年6月23日 下午2:48:17
	 * @param sendData
	 * @return
	 */
	private static boolean sendDataVerifyNoCode(SmsSendData sendData) {
		String[] fields = { "mobile", "type", "sourceEnum" };
		return ParamVerifyUtil.entityIsNotNullByField(sendData, fields);
	}
	/**
	 * 
	 * @Title: sendDataVerifyCustomModel   
	 * @Description: 自定义模板数据填充参数校验  
	 * @param: @param sendData
	 * @param: @return      
	 * @return: boolean
	 * @author：李杰      
	 * @throws
	 */
	private static boolean sendDataVerifyCustomModel(SmsSendData sendData){
		String[] fields = { "mobile", "type", "sourceEnum" ,"modelData" };
		return ParamVerifyUtil.entityIsNotNullByField(sendData, fields);
	}

	@Override
	public Result checkSmsCodeByMobile2(SmsSendData sendData) {
		Result result = ResultUtil.getResult(SmsStatusEnum.PARAM_INCOMPLETE);
		final SmsCodeType type = sendData.getType();
		final String mobile = sendData.getMobile();
		final String smsCode = sendData.getSmsCode();
		CheckDTO checkDTO = new CheckDTO();
		checkDTO.setPhone(mobile);
		checkDTO.setCodeType("Fr170001");
		checkDTO.setCode(smsCode);
		boolean check = smsUtil.check(checkDTO);
		
		if(check){
			ResultUtil.setResult(result, RespCode.Code.SUCCESS);
		}else{
			ResultUtil.setResult(result, SmsStatusEnum.SMS_ERROR);
		}
		
		
		return result;
	}

	/**
	 * 旧通道
	 */
//	private final static String send_msg_url="http://123.207.175.228:9999/four/mobile/view/check/sendMsg";
//	private final static String check_msg_url="http://123.207.175.228:9999/four/mobile/view/check/checkMsg";

	/**
	 * 新通道（测试）
	 */
//	private final static String send_msg_url="http://123.206.92.142:20041/mobile/view/msg/sendMessageForTXY";
//	private final static String check_msg_url="http://123.206.92.142:20041/mobile/view/msg/checkMsg";

	/**
	 * 新通道（正式）
	 */
//	private final static String send_msg_url="http://123.207.175.228:9999/four/mobile/view/msg/sendMessageForTXY";
//	private final static String check_msg_url="http://123.207.175.228:9999/four/mobile/view/msg/checkMsg";

	/**
	 * 调整ip（正式）
	 */
	private final static String SEND_MSG_URL="http://123.206.31.214:20040/mobile/view/msg/sendMessageForTXY";
	private final static String CHECK_MSG_URL="http://123.206.31.214:20040/mobile/view/msg/checkMsg";
	/**
	 * 正则
	 */
	private final  static  String  ZHENGZE = "^((13[0-9])|(15[0-9])|(18[0-9])|(17[0-8])|(147)|(199))\\d{8}$";
	/**
	 * @param telPhone
	 * @param codeType
	 * @param ip
	 * @return
	 */
	@Override
	public Result sendMessageCode(String telPhone,String codeType,String ip) {
		final  String one ="1";
		final  String code = "code";
		Result result =new Result();
		Pattern p = Pattern.compile(ZHENGZE);
		Matcher m = p.matcher(telPhone);
		if(""==telPhone || null==telPhone){
			return new Result(false,"300", "手机号不能为空");
		}
		else if(!m.matches()){
			return new Result(false,"300", "不符合手机格式");
		}
		String modelId = "1";
		String signMsg = "易商通";
//		String sysFrom = "PAY_SYSTEM_FROM_TY";
		String sysFrom = "ty";
		try {
			String s = String.valueOf(1);
			String msgUrl = smsConfig.getSendMsg();//发送短信路径
			String url = msgUrl+"?phone="+telPhone+"&codeType="+codeType+"&modelId="+modelId+"&signMsg="+signMsg+"&sysFrom="+sysFrom+"&ip="+ip;
			String sendGet = HttpClientUtils.getHttpsToGet(url);

			JSONObject json = JSON.parseObject(sendGet);
			logger.info("*******************************{}*****************************", msgUrl);
			if (s.equals(json.get(code).toString())){
				result = new Result(true,json.get("code").toString(), json.get("msg").toString());
			} else {
				result.setSuccess(false);
				result.setCode(json.get("code").toString());
				result.setMessage(json.get("msg").toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"300", "发送失败");
		}
		return result;
	}

    @Override
    public Result checkMsg(String phone, String code, String codeType) {
        try {
            String msgUrl = smsConfig.getCheckMsg();//发送短信路径
            String url = msgUrl+"?phone="+phone+"&code="+code+"&codeType="+codeType;
            String sendGet = HttpClientUtils.getHttpsToGet(url);
            JSONObject json = JSON.parseObject(sendGet);
            return new Result(true,json.get("code").toString(), json.get("msg").toString());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"300", "调用验证验证码接口异常");
        }
    }
}
