# wechat-mp
微信公众号练习
参考项目地址： https://github.com/binarywang/weixin-java-mp-demo-springboot

# 企业号发送消息测试
WxCpMessage message =
				WxCpMessage.TEXT().content("测试消息，请忽略").toUser("111")
				.agentId(wxService.getWxCpConfigStorage().getAgentId()).build();
wxService.messageSend(message);

# 创建菜单
wxService.getMenuService().create(menu);
