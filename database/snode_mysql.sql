/*
Navicat MySQL Data Transfer

Source Server         : snode
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : snode

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2013-05-10 16:22:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `content` text,
  `user_id` int(11) NOT NULL,
  `view_count` int(11) DEFAULT '0',
  `blog_type` int(1) DEFAULT '0',
  `del_status` int(1) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `blog_id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', 'snode 博客介绍', '<strong><span style=\"color:#FF9900;\">Snode</span></strong>由本人在学了<span style=\"color:#009900;\"><strong>nodejs</strong></span>期间捣鼓！<br /> <p>   采用<strong>nodejs</strong>和<strong>mysql</strong>搭建于<strong>Appfog</strong>，部分功能还在完善！ </p> <p>   特色： </p> <ol>   <li>        <span style=\"line-height:1.5;\">后台采用CofferScript编写，使用Cakefile监控coffee代码将其编译成js代码。<br /> 使用方法可参考 <a href=\"https://github.com/twilson63/cakefile-template/blob/master/Cakefile\" target=\"_blank\">Cakefile</a>！<br /> <br /> </span>   </li>   <li>        <span style=\"line-height:1.5;\">使用expressjs mvc框架 <a href=\"http://expressjs.com/api.html\" target=\"_blank\">api</a>, <a href=\"http://expressjs.jser.us/api.html\" target=\"_blank\">中文版api</a>。<br /> 该作者还翻译了jade模版的<a href=\"http://expressjs.jser.us/jade.html\" target=\"_blank\">api</a>。<br /> <br /> </span>      </li>   <li>        <span style=\"line-height:1.5;\">采用<a href=\"https://github.com/didit-tech/FastLegS.git\" target=\"_blank\">FastLegS</a> mysql orm这款mysql orm框架非常不错，力荐！</span>      </li>   <li>        <span style=\"line-height:1.5;\">采用<a href=\"http://jade-lang.com/\" target=\"_blank\">jade</a>模版，开始使用起来比较操蛋，慢慢习惯了还好！</span>    </li> </ol> <p>     &nbsp;&nbsp;&nbsp;&nbsp;原<strong>snode-test</strong>已经下架！源码地址：<a href=\"https://github.com/ChunMengLu/node_mysql_test\" target=\"_blank\">Github</a>&nbsp;<span>部分功能可供参考！</span>  </p> <p>  <br /> 本博客的源码请猛戳右上角的<strong>GitHub</strong>图标！<br /> 有啥好的意见或吐槽请mail到<a href=\"mailto:596392912@qq.com\" target=\"_blank\">596392912@qq.com</a>强烈欢迎！ </p> <p> <br /> </p>', '1', '5', '0', '0', '2013-01-23 04:59:58', '2013-01-23 04:59:58');
INSERT INTO `blog` VALUES ('2', 'GitHub被墙了', '<p>   <span style=\"line-height:1.5;\">&nbsp;&nbsp;&nbsp;&nbsp;今天早上登陆github就发现很慢下午就开始完全不行了，代码页push不上去！</span>  </p> <p>   终于还真是被墙了<img src=\"http://snode.hp.af.cm/kindeditor/plugins/emoticons/images/11.gif\" border=\"0\" alt=\"\" />  </p> <p>    &nbsp; &nbsp;&nbsp;&nbsp;晚上将node-mysql-test 迁移到了&nbsp;<a href=\"https://gitcafe.com\" target=\"_blank\">gitcafe</a>！ </p> <p>   &nbsp; &nbsp; 地址：<a href=\"https://gitcafe.com/Chunmeng/snode-test\" target=\"_blank\">https://gitcafe.com/Chunmeng/snode-test</a><br /> <span id=\"__kindeditor_bookmark_end_53__\"></span>  </p> <p>  &nbsp; &nbsp; 本博地址：<a href=\"https://gitcafe.com/Chunmeng/snode\" target=\"_blank\">https://gitcafe.com/Chunmeng/snode&nbsp;</a> </p> <p>   &nbsp;<span id=\"__kindeditor_bookmark_end_109__\"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </p>', '1', '1', '0', '0', '2013-01-23 14:45:18', '2013-01-23 14:45:18');
INSERT INTO `blog` VALUES ('3', '修改hosts访问Github', '<p>     &nbsp; GitHub被墙了，对我我们这些折腾nodejs的可谓是一灾难！ </p> <p>    &nbsp; 刚在<a href=\"http://www.oschina.net/\" target=\"_blank\">oschina</a>上看到<a href=\"https://smarthosts.googlecode.com/svn/trunk/hosts\" target=\"_blank\">smarthosts</a>（戳一下）更新了对GitHub的支持在此分享给大家！ </p> <p>  &nbsp; Windows 32位的目录<strong>&nbsp;</strong><strong>C:\\WINDOWS\\system32\\drivers\\etc</strong>  </p> <p>  &nbsp; 64位的没有<span><strong>etc</strong>这个目录的注意先新建一个<strong>etc</strong>目录</span>  </p> <p>  <span>&nbsp; 将<a href=\"https://smarthosts.googlecode.com/svn/trunk/hosts\" target=\"_blank\">smarthosts</a>上下载的<strong>hosts.txt</strong>去掉.txt后缀覆盖<strong>ect</strong>下的<strong>hosts</strong><strong></strong></span>  </p> <p>  <span><strong>&nbsp; </strong>linux的请自己去google吧<img src=\"http://snode.hp.af.cm/kindeditor/plugins/emoticons/images/54.gif\" border=\"0\" alt=\"\" /></span> </p>', '1', '1', '0', '0', '2013-01-23 00:59:41', '2013-01-23 00:59:41');
INSERT INTO `blog` VALUES ('4', 'FastLegS修复了排序的bug', '<p>\r\n   前几天发现mysql orm&nbsp;<strong><a href=\"https://github.com/didit-tech/FastLegS\" class=\"js-current-repository\">FastLegS</a></strong>排序无效果，\r\n</p>\r\n<p>\r\n   在GitHub发布了个lssue，昨天晚上看到GitHub的消息bug已经fixed！\r\n</p>\r\n<p>\r\n  <img src=\"http://snode.hp.af.cm/kindeditor/plugins/emoticons/images/13.gif\" border=\"0\" alt=\"\" />顺便测试下，新的传图！\r\n</p>\r\n<p>\r\n    <img src=\"http://res.cloudinary.com/ha1jeueli/image/upload/v1358991985/1358991985241.jpg\" alt=\"\" /> \r\n</p>\r\n<p>\r\n 附上几个npm命令：\r\n</p>\r\n<p>\r\n<pre class=\"prettyprint lang-rb\"># 清理缓存\r\nnpm cache clean \r\n#使用NPM安装包：\r\nnpm install packname\r\n# 使用NPM更新包：\r\nnpm update packname\r\n# 使用NPM卸载包：\r\nnpm uninstall packname</pre>\r\n</p>', '1', '0', '0', '0', '2013-01-24 01:51:26', '2013-03-14 22:24:44');
INSERT INTO `blog` VALUES ('5', 'AppFog Add-ons日志服务之Logentries', '<p>\r\n   偶然在Appfog的Add-ons中发现了Logentries！\r\n</p>\r\n<p>\r\n <img src=\"http://res.cloudinary.com/ha1jeueli/image/upload/v1359005429/1359005428472.jpg\" alt=\"\">\r\n</p>\r\n<p>\r\n    <br>\r\n</p>\r\n<p>\r\n 主页 <a href=\"https://logentries.com/\" target=\"_blank\">https://logentries.com/</a><br>\r\n在项目中使用也是So easy，下面是Nodejs官方的使用\r\n</p>\r\n<p>\r\n</p><pre class=\"prettyprint lang-js\">Install\r\nnpm install node-logentries</pre>\r\n<pre class=\"prettyprint lang-js\">Use\r\n\r\nvar logentries = require(\'node-logentries\');\r\nvar log = logentries.logger({token:\'process.env.LOGENTRIES_TOKEN\'});</pre>\r\n<pre class=\"prettyprint lang-js\">// level specific methods like \'info\', \'debug\', etc.\r\nlog.info(\"I\'m a Lumberjack and I\'m OK\")\r\n// generic log method, also accepts JSON entries\r\nlog.log(\"debug\", {sleep:\"all night\", work:\"all day\"})</pre>\r\n更多请参考文档 <a href=\"https://logentries.com/doc/appfog/\" target=\"_blank\">https://logentries.com/doc/appfog/</a>\r\n<p></p>\r\n<p>\r\n    <img src=\"http://res.cloudinary.com/ha1jeueli/image/upload/v1359005646/1359005646180.jpg\" alt=\"\">点击，即可查看最近的日志\r\n</p>\r\n<p>\r\n    本博已经成功使用<span>Logentries！</span>\r\n</p>\r\n<p>\r\n <img src=\"http://res.cloudinary.com/ha1jeueli/image/upload/v1359005759/1359005758664.jpg\" alt=\"\">\r\n</p>\r\n<p>\r\n    有啥疑问可以联系我哦<img src=\"http://snode.hp.af.cm/kindeditor/plugins/emoticons/images/29.gif\" border=\"0\" alt=\"\"><br>\r\n</p>', '1', '0', '0', '0', '2013-01-24 05:36:41', '2013-03-14 22:23:54');
INSERT INTO `blog` VALUES ('6', '图像管理之Cloudinary使用', '<p>\r\n   在我纠结上传到Appfog博客里图片，在af update时会被更新掉的时候，\r\n</p>\r\n<p>\r\n  看到了这个Add-ons：Cloudinary(图像管理服务)\r\n</p>\r\n<p>\r\n  <img src=\"http://res.cloudinary.com/ha1jeueli/image/upload/v1359041822/1359041822290.jpg\" alt=\"\"> \r\n</p>\r\n<p>\r\n   Google翻译：<br>\r\nCloudinary简化了所有Web应用程序的图像管理需要。轻松地将影像上传到云。<br>\r\n自动进行智能调整图像大小，裁剪，合并，重叠，水印，应用效果，旋转，格式转换，<br>\r\n无需安装任何复杂的软件。通过一个快速的CDN图像无缝地交付。<br>\r\nCloudinary提供全面的API和管理能力，并与现有的或新的web应用程序，很容易集成。\r\n</p>\r\n<p>\r\n nodejs使用： <a href=\"http://cloudinary.com/documentation/appfog_integration#nodejs\" target=\"_blank\">http://cloudinary.com/documentation/appfog_integration#nodejs</a> \r\n</p>\r\n<p>\r\n 本地使用： <a href=\"http://cloudinary.com/documentation/appfog_integration#local_environment\" target=\"_blank\">http://cloudinary.com/documentation/appfog_integration#local_environment</a> \r\n</p>\r\n<p>\r\n   本地使用的这个本人还没整明白！有整明白的同志请留个言噢！\r\n</p>\r\n<p>\r\n <br>\r\n</p>\r\n<p>\r\n 我简单的使用了下给各位一个参考（CoffeeScript）：\r\n</p>\r\n<p>\r\n   <br>\r\n</p>\r\n<pre class=\"prettyprint lang-js\">cloudinary = require \'cloudinary\'\r\n</pre>\r\n<pre class=\"prettyprint lang-js\"># Cloudinary 图片上传\r\nexports.editor = (req, res) -&gt;\r\n    tmp_path = req.files.imgFile.path\r\n    img_name = new Date().getTime()\r\n    # Cloudinary api\r\n    stream = cloudinary.uploader.upload_stream (result) -&gt;\r\n        console.log result\r\n        # del local img\r\n        fs.unlink tmp_path, (err) -&gt;\r\n            console.log err if err\r\n            log.log \"debug\", err if err\r\n        res.json error: 0, url:result.url    \r\n    , public_id: img_name \r\n    fs.createReadStream(tmp_path, encoding: \'binary\').on(\'data\', stream.write).on(\'end\', stream.end)</pre>\r\n<p>\r\n <br>\r\n</p>\r\n<p>\r\n 欢迎拍砖，现在Snode有了自己的域名：<a href=\"http://dreamlu.net/\" target=\"_blank\">http://dreamlu.net/</a> \r\n</p>\r\n<p>\r\n   <br>\r\n</p>', '1', '1', '0', '0', '2013-01-24 15:48:30', '2013-03-14 22:23:22');
INSERT INTO `blog` VALUES ('7', 'Appfog dot.tk namecheap搭建免费顶级域名动态dns站点', '<p class=\"p0\">\r\n <strong><a href=\"https://www.appfog.com/\" target=\"_blank\">Appfog</a></strong> \r\n</p>\r\n<p class=\"p0\">\r\n  &nbsp;&nbsp;&nbsp;&nbsp;2G<span>的免费空间和数据库支持，访问速度还可以，偶尔Appfog管理网站很卡&nbsp;<span>，总的说来相当之哈皮</span>！</span> \r\n</p>\r\n<p class=\"p0\">\r\n    <span></span> \r\n</p>\r\n<p class=\"p0\">\r\n  &nbsp;&nbsp;&nbsp;&nbsp;Appfog<span>支持的开发语言和框架：</span> \r\n</p>\r\n<p class=\"p0\">\r\n <span>&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"http://res.cloudinary.com/ha1jeueli/image/upload/v1359208800/1359208799108.png\" alt=\"\"></span><span style=\"line-height:1.5;\">&nbsp; &nbsp;&nbsp;</span> \r\n</p>\r\n<p class=\"p0\">\r\n  <span></span> \r\n</p>\r\n<p class=\"p0\">\r\n  &nbsp; &nbsp; 支持的数据库：\r\n</p>\r\n<p class=\"p0\">\r\n   &nbsp;&nbsp;&nbsp;&nbsp;<img src=\"http://res.cloudinary.com/ha1jeueli/image/upload/v1359208930/1359208929623.png\" alt=\"\"> \r\n</p>\r\n<p class=\"p0\">\r\n  <br>\r\n</p>\r\n<p class=\"p0\">\r\n    &nbsp;&nbsp;&nbsp;&nbsp;以及丰富的第三方服务，这里就不一一列举了！\r\n</p>\r\n<p class=\"p0\">\r\n   &nbsp;&nbsp;&nbsp;&nbsp;前面已经介绍过日志<a href=\"http://www.dreamlu.net/blog/5\" target=\"_blank\">Logentries</a>和图片<a href=\"http://www.dreamlu.net/blog/6\" target=\"_blank\">Cloudinary</a>服务。\r\n</p>\r\n<p class=\"p0\">\r\n &nbsp;&nbsp;&nbsp;&nbsp;详细文档：<a href=\"https://docs.appfog.com/\">https://docs.appfog.com/</a> \r\n</p>\r\n<p class=\"p0\">\r\n <br>\r\n</p>\r\n<p class=\"p0\" style=\"background:#FFFFFF;\">\r\n  <strong><a href=\"http://www.dot.tk/\" target=\"_blank\">Dot.tk</a></strong> \r\n</p>\r\n<p class=\"p0\" style=\"background:#FFFFFF;\">\r\n &nbsp;&nbsp;&nbsp;&nbsp;.TK<span>是南太平洋岛国托克劳的国家域名</span>，免费注册一个帐户可以任意申请<span>.TK</span><span>域名，支持域名转发（可隐藏原</span><span>URL</span><span>）、电邮转发、</span><span>A</span><span>记录解析、</span><span>CNAME</span><span>。</span> \r\n</p>\r\n<p class=\"p0\" style=\"background:#FFFFFF;\">\r\n    &nbsp;&nbsp;&nbsp;&nbsp;并且<span>google</span><span>对</span><span>.tk</span><span>的收录并没有歧视，与其他顶级域名是一样</span>！\r\n</p>\r\n<p class=\"p0\" style=\"background:#FFFFFF;\">\r\n  <br>\r\n</p>\r\n<p class=\"p0\">\r\n    <strong><a href=\"http://www.namecheap.com/\" target=\"_blank\">namecheap.com</a></strong> \r\n</p>\r\n<p class=\"p0\">\r\n <span>&nbsp;&nbsp;&nbsp;&nbsp;是一个</span><span>DNS</span><span>提供商，也提供免费服务。这个相比其他</span><span>DNS</span><span>提供商最大的优点就是可以自定义</span><span>TTL</span><span>，也就是</span><span>dns</span><span>更新频率，非常适合动态</span><span>IP</span><span>用户。</span> \r\n</p>\r\n<p class=\"p0\">\r\n    <br>\r\n</p>\r\n<p class=\"p0\">\r\n    <strong>域名绑定和</strong><span><strong>dns</strong></span><span><strong>配置：</strong></span> \r\n</p>\r\n<p class=\"p0\">\r\n   &nbsp; &nbsp; 1.&nbsp; &nbsp;&nbsp;<span style=\"line-height:1.5;\">申请.tk域名</span> \r\n</p>\r\n<p class=\"p0\">\r\n &nbsp;&nbsp;&nbsp;&nbsp;<img src=\"http://res.cloudinary.com/ha1jeueli/image/upload/v1359209479/1359209479315.png\" alt=\"\"> \r\n</p>\r\n<p class=\"p0\">\r\n  &nbsp; &nbsp; 2.&nbsp; &nbsp;&nbsp;<span style=\"line-height:1.5;\">&nbsp;配置域名</span> \r\n</p>\r\n<p class=\"p0\">\r\n  &nbsp; &nbsp;&nbsp;<span style=\"line-height:1.5;\">本博已</span><span style=\"line-height:1.5;\">snode.tk</span><span style=\"line-height:1.5;\">和</span><a href=\"http://www.snode.tk\">www.snode.tk</a><span style=\"line-height:1.5;\">为例！</span> \r\n</p>\r\n<p class=\"p0\">\r\n &nbsp;&nbsp;&nbsp;&nbsp;<img src=\"http://res.cloudinary.com/ha1jeueli/image/upload/v1359209595/1359209595091.png\" alt=\"\"> \r\n</p>\r\n<p class=\"p0\">\r\n  &nbsp; &nbsp;&nbsp;<span style=\"line-height:1.5;\">第一个是域名转发，选择这个点</span><span style=\"line-height:1.5;\">configure</span><span style=\"line-height:1.5;\">，如果接下来在下面输入</span><a href=\"http://www.google.com/\">http://www.google.com</a><span style=\"line-height:1.5;\">那么当你访问</span><span style=\"line-height:1.5;\">snode.tk的时候就会自动跳转到</span><span style=\"line-height:1.5;\">Google</span><span style=\"line-height:1.5;\">了。</span> \r\n</p>\r\n<p class=\"p0\" style=\"text-align:justify;\">\r\n    &nbsp;&nbsp;&nbsp;&nbsp;第二个是使用<span>dot.tk</span><span>本身的免费</span><span>Dns</span><span>服务，有</span><span>A</span><span>，</span><span>CNAME</span><span>，</span><span>MX</span><span>三个选项，可以设置很多子域名，要求不高可以自己用这个。</span><br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;第三个就是我要说的重点了，我是这么设置的：<span>freedns1.registrar-servers.com</span><span>这三个就是</span><span>namecheap.com</span><span>提供的免费域名解析地址。</span> \r\n</p>\r\n<p class=\"p0\" style=\"text-align:justify;\">\r\n <span> </span> \r\n</p>\r\n<p class=\"p0\">\r\n &nbsp;&nbsp;&nbsp;&nbsp;3.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;namecheap.com Dns<span>设置关联</span><span style=\"line-height:1.5;\">&nbsp; &nbsp;</span> \r\n</p>\r\n<p class=\"p0\">\r\n    <span> </span> \r\n</p>\r\n<p class=\"p0\">\r\n &nbsp;&nbsp;&nbsp;&nbsp;首先注册登录选择<span>FreeDns,</span><span>就是这个界面</span><span>,</span><span>输入我们要</span>绑定的域名snode.tk<span>点击</span><span>Next</span><span>，</span> \r\n</p>\r\n<p class=\"p0\">\r\n    &nbsp;&nbsp;&nbsp;&nbsp;freedns1.registrar-servers.com<span>这几个出现了：</span> \r\n</p>\r\n<p>\r\n  <br>\r\n</p>\r\n<p class=\"p0\">\r\n    <span>&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"http://res.cloudinary.com/ha1jeueli/image/upload/v1359209739/1359209738639.png\" alt=\"\"><br>\r\n</span> \r\n</p>\r\n<p class=\"p0\">\r\n <span> </span> \r\n</p>\r\n<p class=\"p0\">\r\n &nbsp;&nbsp;&nbsp;&nbsp;点击“Free Dns”\r\n</p>\r\n<p class=\"p0\">\r\n    &nbsp;&nbsp;&nbsp;&nbsp;<img src=\"http://res.cloudinary.com/ha1jeueli/image/upload/v1359209883/1359209883310.png\" alt=\"\"> \r\n</p>\r\n<p class=\"p0\">\r\n  &nbsp; &nbsp;&nbsp;<span style=\"line-height:1.5;\">点击</span><span style=\"line-height:1.5;\">“</span><span style=\"line-height:1.5;\">Add&nbsp;DNS&nbsp;Service&nbsp;for&nbsp;Selected&nbsp;Domains</span><span style=\"line-height:1.5;\">”</span> \r\n</p>\r\n<p class=\"p0\">\r\n   &nbsp; &nbsp; 下一步“<span style=\"line-height:1.5;\">Go&nbsp;to&nbsp;the&nbsp;Hosted&nbsp;Domains&nbsp;Page”<span>绑定ip</span>/url</span><span style=\"line-height:1.5;\"></span> \r\n</p>\r\n<p class=\"p0\">\r\n &nbsp;&nbsp;&nbsp;&nbsp;<img src=\"http://res.cloudinary.com/ha1jeueli/image/upload/v1359210014/1359210014120.png\" alt=\"\"> \r\n</p>\r\n<p class=\"p0\">\r\n  &nbsp;&nbsp;&nbsp;&nbsp;<span>绿色的用来添加，此处的</span><span>Ip/Url</span><span>从</span><span>Appfog</span><span>中获取！</span> \r\n</p>\r\n<p class=\"p0\">\r\n  &nbsp;&nbsp;&nbsp;&nbsp;<img src=\"http://res.cloudinary.com/ha1jeueli/image/upload/v1359210144/1359210143882.png\" alt=\"\"> \r\n</p>\r\n<p class=\"p0\">\r\n  &nbsp;&nbsp;&nbsp;&nbsp;<img src=\"http://res.cloudinary.com/ha1jeueli/image/upload/v1359210171/1359210171237.png\" alt=\"\"> \r\n</p>\r\n<p class=\"p0\">\r\n  <br>\r\n</p>\r\n<p class=\"p0\">\r\n    设置要<span>30</span><span>分钟甚至几个小时才能生效</span>，稍安毋躁！\r\n</p>\r\n<p class=\"p0\" style=\"background:#FFFCF6;\">\r\n <strong>临渊羡鱼</strong><span><strong>,</strong></span><span><strong>不如退而结网</strong></span><span><strong>;</strong></span><span><strong>扬汤止沸</strong></span><span><strong>,</strong></span><span><strong>不如釜底抽薪</strong></span><strong>！</strong><span style=\"line-height:1.5;\"></span> \r\n</p>\r\n<p class=\"p0\" style=\"background:#FFFCF6;\">\r\n   <br>\r\n</p>', '1', '3', '0', '0', '2013-01-26 14:47:47', '2013-03-14 22:43:48');
INSERT INTO `blog` VALUES ('8', '使用jade制作邮件模版', '使用到的模块<br />\r\nemailjs，GitHub：<a href=\"https://github.com/eleith/emailjs\" target=\"_blank\">https://github.com/eleith/emailjs</a> &nbsp;有详细的使用说明<br />\r\n<p>\r\n   jade，GitHub：<a href=\"https://github.com/visionmedia/jade\" target=\"_blank\">https://github.com/visionmedia/jade</a> \r\n</p>\r\n<p>\r\n   1. 示例模版signup_send.jade\r\n</p>\r\n<p>\r\n  <img src=\"http://res.cloudinary.com/ha1jeueli/image/upload/v1359957753/1359957752693.jpg\" alt=\"\" /> \r\n</p>\r\n<p>\r\n 2. 首先确认已按照emailjs的demo调试OK\r\n</p>\r\n<p>\r\n   代码：\r\n</p>\r\n<p>\r\n<pre class=\"prettyprint lang-js\">// 读取邮件模版signup_send.jade\r\nvar path = __dirname + \'/../views/email/signup_mail_send.jade\';\r\nvar str = fs.readFileSync(path, \'utf8\');\r\nvar fn = jade.compile(str, { filename: path, pretty: true });\r\n// 邮件里的url得用全路径 这里的baseUrl是域名\r\nvar baseUrl = config.domain;\r\n// 填充jade 参数 user 和 verifyUrl 和 baseUrl\r\nvar verifyUrl = baseUrl + \'/finish?code=\' + code;\r\nvar actual = fn({ user: user.nick_name, baseUrl: baseUrl, verifyUrl: verifyUrl });\r\n// mail 信息填充\r\nmessage.to = user.email;\r\nmessage.text = \"欢迎加Snode社区\";\r\nmessage.subject = \"欢迎加Snode社区\";\r\nmessage.attachment[0].data = actual.trim();\r\n// 发送邮件 具体参看 emailjs 文档\r\nserver.send(message, function(err, message) {\r\n   console.log(err || message);\r\n});<span style=\"font-family:\'sans serif\', tahoma, verdana, helvetica;font-size:12px;line-height:1.5;\"></span></pre>\r\n</p>\r\n效果预览：<a href=\"http://dreamlu.net/mail\" target=\"_blank\">http://dreamlu.net/mail</a><br />\r\n具体注册流程可以参看snode-test：<a href=\"https://github.com/ChunMengLu/node_mysql_test\" target=\"_blank\">https://github.com/ChunMengLu/node_mysql_test</a><br />\r\nsnode已经砍掉注册流程了！\r\n<p>\r\n   <br />\r\n</p>', '1', '4', '0', '0', '2013-02-04 08:08:08', '2013-03-14 22:20:45');
INSERT INTO `blog` VALUES ('9', 'express路由的理解', '捣鼓nodejs有段时间了，写点东西吧！<br />\r\n下面是本人的一点拙见，好吧切入正题。<br />\r\n<p>\r\n  本例使用sonde的 <a href=\"https://github.com/ChunMengLu/coffee-snode/blob/master/snode_server/routes.coffee\" target=\"_blank\">routes</a>和另外一位兄弟（<a href=\"http://t.qq.com/willerce\" target=\"_blank\">willerce</a>）的<a href=\"https://github.com/willerce/noderce/blob/master/routes.js\" target=\"_blank\">routes</a>来说明\r\n</p>\r\n<p>\r\n  1. 请求会从你的routes列表中由上之下依次去匹配直到找到相应的route直到404 not found<br />\r\n在snode开头中有这么一行\r\n</p>\r\n<pre class=\"prettyprint lang-rb\"># 配置session 页面中使用 user 获取\r\n# app.all \'*\', index.auth</pre>\r\n<p>\r\n  <span style=\"color:#E53333;\">*</span> 这段代码曾经在snode-test中使用对session和用户cookie处理详情请见<a href=\"https://github.com/ChunMengLu/node_mysql_test/blob/master/controllers/index.js\" target=\"_blank\">index.js</a>&nbsp;\r\n</p>\r\n<p>\r\n   这里会<span>拦截</span>所有的请求，哪怕是public下的css，js（这也说明静态文件其实也是占用了一个路由的）\r\n</p>\r\n<p>\r\n  snode路由底部\r\n</p>\r\n<pre class=\"prettyprint lang-rb\">###\r\npage note Found\r\n###\r\napp.get \'*\', (req, res, next) -&gt;\r\n  if /.*\\.(gif|jpg|jpeg|png|bmp|js|css|html).*$/.test req.originalUrl\r\n        next()\r\n  else  \r\n      res.render \'error/404\'</pre>\r\n由于前面没处理<span>静态文件</span>这里被再次拦截\r\n<p>\r\n    <br />\r\n</p>\r\n<p>\r\n   2. 灵活的使用app.all过滤请求 <br />\r\n曾经看到willerce对后台的过滤部分\r\n</p>\r\n<pre class=\"prettyprint lang-rb\">app.get(\'/admin/post\', admin.auth_user, admin.postIndex);\r\napp.get(\'/admin/post/write\', admin.auth_user, admin.postWrite);\r\napp.post(\'/admin/post/write\', admin.auth_user, admin.postWrite);\r\n......</pre>\r\n表示不淡定了<br />\r\n<div style=\"text-align:left;\">\r\n <span style=\"line-height:1.5;\">去查找了express文档发现app.all这个东西</span> \r\n</div>\r\n<div style=\"text-align:left;\">\r\n   <span style=\"line-height:1.5;\">中文文档</span><span style=\"line-height:1.5;\"><a href=\"http://expressjs.jser.us/api.html#app.all\" target=\"_blank\">app.all</a></span><span style=\"line-height:1.5;\">这里的翻译狠到位，强赞！</span> \r\n</div>\r\n<p style=\"text-align:left;\">\r\n    snode中权限部分的拦截简单明了\r\n</p>\r\n<pre class=\"prettyprint lang-js\">app.all \'/admin/*\', adminLogin.auth</pre>\r\n大过年的真是没心思上班啊，有木有！我在这`提钱`祝大家新年快乐！\r\n<p>\r\n  <br />\r\n</p>', '1', '27', '0', '0', '2013-02-04 07:54:31', '2013-03-14 22:27:11');

-- ----------------------------
-- Table structure for blog_tags
-- ----------------------------
DROP TABLE IF EXISTS `blog_tags`;
CREATE TABLE `blog_tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blog_id` int(11) DEFAULT NULL,
  `tag_id` int(11) DEFAULT NULL,
  `del_status` int(1) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `blog_tags_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_tags
-- ----------------------------

-- ----------------------------
-- Table structure for mail_verify
-- ----------------------------
DROP TABLE IF EXISTS `mail_verify`;
CREATE TABLE `mail_verify` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `verify_code` varchar(50) DEFAULT NULL,
  `del_status` int(1) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mail_verify_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mail_verify
-- ----------------------------

-- ----------------------------
-- Table structure for tags
-- ----------------------------
DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `del_status` int(1) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tag_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tags
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(50) DEFAULT NULL,
  `password` varchar(64) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `email_verify` int(1) DEFAULT '0',
  `head_photo` varchar(100) DEFAULT NULL,
  `sex` int(1) DEFAULT '0',
  `birthday` date DEFAULT NULL,
  `status` int(1) DEFAULT '0',
  `last_login_time` datetime DEFAULT NULL,
  `signature` varchar(100) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `liveness` int(11) DEFAULT '0',
  `contribution` int(11) DEFAULT '0',
  `authority` int(1) DEFAULT '0',
  `del_status` int(1) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_info_id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'DreamLu', 'ed723d19ee3f7f2c1dd7eab5c11db0b8', 'qq596392912@gmail.com', '1', 'http://www.gravatar.com/avatar/edc6da2f2a407934e046189ad64186c7', '0', '1989-10-30', '0', '2013-05-05 00:00:19', '人生就象愤怒的小鸟，你失败了，最起码还有几只猪在笑。', 'http://dreamlu.net/', '0', '0', '0', '0', '2013-05-05 00:00:02', '2013-05-05 00:00:02');