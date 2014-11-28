USE [milmodb]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE dbo.mix_service(
	office_id int NOT NULL,
	from_office_time_kayoi NVARCHAR(4) NULL,
	to_office_time_kayoi NVARCHAR(4) NULL,
	from_office_time_stay NVARCHAR(4) NULL,
	to_office_time_stay NVARCHAR(4) NULL,
	service_area NVARCHAR(MAX) NULL,
	sougei_1 BIT NULL,
	nintisyo_1 BIT NULL,
	nintisyo_2 BIT NULL,
	jigyokaishishien BIT NULL,
	kinkyujihoumon BIT NULL,
	specialkanri_1 BIT NULL,
	specialkanri_2 BIT NULL,
	terminalcare BIT NULL,
	service_supply_1 BIT NULL,
	service_supply_2 BIT NULL,
	service_supply_3 BIT NULL,
	carestaffkaizen_1 BIT NULL,
	carestaffkaizen_2 BIT NULL,
	carestaffkaizen_3 BIT NULL,
	tube_feeding BIT NULL,
	ivh BIT NULL,
	iv_drip BIT NULL,
	bladder_catheterization BIT NULL,
	nephrostomy BIT NULL,
	hot BIT NULL,
	respirator BIT NULL,
	capd BIT NULL,
	artificial_anus BIT NULL,
	artificial_bladder BIT NULL,
	tracheal_cannula BIT NULL,
	absorb BIT NULL,
	drug_pain_control BIT NULL,
	medical_other_name NVARCHAR(30) NULL,
	medical_other BIT NULL,
	morning_price INT NOT NULL,
	lunch_price INT NOT NULL,
	dinner_price INT NOT NULL,
	snack_price INT NOT NULL,
	stay_price INT NOT NULL,
	other_name_1 NVARCHAR(20) NULL,
	other_price_1 INT NOT NULL,
	other_biko_1 NVARCHAR(MAX) NULL,
	other_name_2 NVARCHAR(20) NULL,
	other_price_2 INT NOT NULL,
	other_biko_2 NVARCHAR(MAX) NULL,
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
