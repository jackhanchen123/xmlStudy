# xmlStudy
xml学习。idea集成git,上传githuab学习

上传到github注意事项

1。idea集成git。在设置中git设置中添加git.exe地址即可。test一下。

2.本地项目没有git选项，在vcs中create git repository.

3.push时一直报错，或者是在Idee登录网址打不开。
原来是C:\Windows\System32\drivers\etc中配置了网址到本地。#0.0.0.0 account.jetbrains.com注释掉
再次打开网址，需要github网页授权，授权成功，就能push成功了。
