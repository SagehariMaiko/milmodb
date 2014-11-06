milmodb
=======

Jsonファイルの保存配下

milmodb\data\Json


logは以下に出力される

CreateJsonDB実行時：milmodb\log\CreateJsonDB

CreateValidateDB実行時：milmodb\log\CreateValidateDB



CreateJsonDB実行で、Jsonファイルを読み込み、j_***テーブルへ格納する
CreateValidateDB実行で、j_***テーブルからv_***テーブルへ移動。その際にConvertとValidateがかかる
