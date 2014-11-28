USE [milmodb]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE dbo.local_based_specified_charge(
	office_id int NOT NULL,
	private_kinou BIT NULL,
	medicalkikanrenkei BIT NULL,
	night_nursing BIT NULL,
	caregiving BIT NULL,
	carestaffkaizen_1 BIT NULL,
	carestaffkaizen_2 BIT NULL,
	carestaffkaizen_3 BIT NULL,
	shortuse_local_specified BIT NULL,
	personal_distribution BIT NULL,
	payment_method NVARCHAR(20) NULL,
	lumpsum_name NVARCHAR(20) NULL,
	lumpsum_num NVARCHAR(20) NULL,
	lumpsum_from INT NOT NULL,
	lumpsum_to INT NOT NULL,
	lumpsum_avg INT NOT NULL,
	lumpsum_biko NVARCHAR(MAX) NULL,
	repaymentrate INT NOT NULL,
	recoveryperiod NVARCHAR(MAX) NULL,
	cancel_returnmoney NVARCHAR(MAX) NULL,
	controlcost INT NOT NULL,
	controlcost_biko NVARCHAR(MAX) NULL,
	mealprice INT NOT NULL,
	mealprice_biko NVARCHAR(MAX) NULL,
	fuelprice INT NOT NULL,
	fuelprice_biko NVARCHAR(MAX) NULL,
	personal_distribution_2 BIT NULL,
	personal_distribution_2_biko NVARCHAR(MAX) NULL,
	indivudual_select BIT NULL,
	indivudual_select_biko NVARCHAR(MAX) NULL,
	eq_rent BIT NULL,
	eq_rent_from INT NOT NULL,
	eq_rent_to INT NOT NULL,
	eq_ent_avg INT NOT NULL,
	eq_rent_biko NVARCHAR(MAX) NULL,
	other_getsugaku NVARCHAR(MAX) NULL,
	other_lumpsum NVARCHAR(MAX) NULL,
PRIMARY KEY CLUSTERED
(
	[office_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)

GO
