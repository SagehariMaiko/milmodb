USE [milmodb]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE dbo.routine_home(
	office_id int NOT NULL,
	office_type NVARCHAR(30) NULL,
	service_area NVARCHAR(MAX) NULL,
	service_supply_1 BIT NULL,
	service_supply_2 BIT NULL,
	service_supply_3 BIT NULL,
	carestaffkaizen_1 BIT NULL,
	carestaffkaizen_2 BIT NULL,
	carestaffkaizen_3 BIT NULL,
	kinkyujihoumon BIT NULL,
	specialkanri_1 BIT NULL,
	specialkanri_2 BIT NULL,
	terminalcare BIT NULL,
	taiinjikyoudousidou BIT NULL,
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
	outarea_price NVARCHAR(MAX) NULL,
	operator_price NVARCHAR(MAX) NULL,
	userchargecut BIT NULL,
PRIMARY KEY CLUSTERED
(
	[office_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)

GO
