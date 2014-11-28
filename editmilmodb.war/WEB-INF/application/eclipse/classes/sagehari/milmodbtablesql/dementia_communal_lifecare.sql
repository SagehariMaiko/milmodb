USE [milmodb]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE dbo.dementia_communal_lifecare(
	office_id int NOT NULL,
	night_care_1 BIT NULL,
	night_care_2 BIT NULL,
	nintisyoshinritaio BIT NULL,
	jyakunenseiriyo BIT NULL,
	sub_caregiving BIT NULL,
	sub_medicalrenkeitaisei BIT NULL,
	taikyojisoudan BIT NULL,
	nintisyosenmon_1 BIT NULL,
	nintisyosenmon_2 BIT NULL,
	service_supply_1 BIT NULL,
	service_supply_2 BIT NULL,
	service_supply_3 BIT NULL,
	carestaffkaizen_1 BIT NULL,
	carestaffkaizen_2 BIT NULL,
	carestaffkaizen_3 BIT NULL,
	shortuse_communal_lifecare BIT NULL,
	share_dementia_daycare BIT NULL,
	movein_capacity NVARCHAR(20) NULL,
	rent INT NOT NULL,
	deposit INT NOT NULL,
	security_money INT NOT NULL,
	morning_price INT NOT NULL,
	lunch_price INT NOT NULL,
	dinner_price INT NOT NULL,
	snack_price INT NOT NULL,
	meal_day_price INT NOT NULL,
	hairdressing_price_2 INT NOT NULL,
	hairdressing_biko_2 NVARCHAR(MAX) NULL,
	diaper_price INT NOT NULL,
	diaper_biko NVARCHAR(MAX) NULL,
	other_name_3 NVARCHAR(20) NULL,
	other_price_3 INT NOT NULL,
	other_biko_3 NVARCHAR(MAX) NULL,
	other_name_4 NVARCHAR(20) NULL,
	other_price_4 INT NOT NULL,
	other_biko_4 NVARCHAR(MAX) NULL,
	other_name_5 NVARCHAR(20) NULL,
	other_price_5 INT NOT NULL,
	other_biko_5 NVARCHAR(MAX) NULL,
PRIMARY KEY CLUSTERED
(
	[office_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)

GO
