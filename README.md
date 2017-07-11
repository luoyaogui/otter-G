<h1>
<a name="%E4%BB%80%E4%B9%88%E6%98%AFcanal-" class="anchor" href="#%E4%BB%80%E4%B9%88%E6%98%AFcanal-"><span class="octicon octicon-link"></span></a>什么是otter? </h3>
链接地址：<a href="http://github.com/alibaba/otter">http://github.com/alibaba/otter</a>
</h1>

<p> </p>
<h1>
<a name="%E9%97%AE%E9%A2%98%E5%8F%8D%E9%A6%88" class="anchor" href="#%E9%97%AE%E9%A2%98%E5%8F%8D%E9%A6%88"><span class="octicon octicon-link"></span></a>改造描述</h1>
<h3>
<a name="%E6%B3%A8%E6%84%8Fcanalotter-qq%E8%AE%A8%E8%AE%BA%E7%BE%A4%E5%B7%B2%E7%BB%8F%E5%BB%BA%E7%AB%8B%E7%BE%A4%E5%8F%B7161559791-%E6%AC%A2%E8%BF%8E%E5%8A%A0%E5%85%A5%E8%BF%9B%E8%A1%8C%E6%8A%80%E6%9C%AF%E8%AE%A8%E8%AE%BA" class="anchor" href="#%E6%B3%A8%E6%84%8Fcanalotter-qq%E8%AE%A8%E8%AE%BA%E7%BE%A4%E5%B7%B2%E7%BB%8F%E5%BB%BA%E7%AB%8B%E7%BE%A4%E5%8F%B7161559791-%E6%AC%A2%E8%BF%8E%E5%8A%A0%E5%85%A5%E8%BF%9B%E8%A1%8C%E6%8A%80%E6%9C%AF%E8%AE%A8%E8%AE%BA"><span class="octicon octicon-link"></span></a>注意：了解改了哪些地方，最好的方法是download一份otter，使用BCompare这类工具对比即知！</h3>

<p>1.  <span>sql： otter-4.2.13/manager/deployer/src/main/resources/sql</span></p>
<p><span>2.  </span><span哪些表添加了字段USER_ID（对应USER表的id）： CANAL、CHANNEL、DATA_MATRIX、DATA_MEDIA_SOURCE、DATA_MEDIA</span></p>
<p><span>3.  </span><span>页面变更： 涉及到上述表相关的页面或服务类</span></p>
<p><span>4.  </span><span>权限：由SUPERIOR、ADMIN、OPERATOR组成，只有登录成功的用户才能查看相关信息，否则一直在登录页面</p>
<p><span>4.  </span><span>canal源码中Canal类添加了userId字段，以及相关的set/get方法</p>
<p> </p>
