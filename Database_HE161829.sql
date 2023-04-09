USE [master]
GO
/****** Object:  Database [DionPrj]    Script Date: 3/24/2023 10:34:49 AM ******/
CREATE DATABASE [DionPrj]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DionPrj', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\DionPrj.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'DionPrj_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\Log\DionPrj.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [DionPrj] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DionPrj].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DionPrj] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DionPrj] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DionPrj] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DionPrj] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DionPrj] SET ARITHABORT OFF 
GO
ALTER DATABASE [DionPrj] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [DionPrj] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DionPrj] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DionPrj] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DionPrj] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DionPrj] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DionPrj] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DionPrj] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DionPrj] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DionPrj] SET  DISABLE_BROKER 
GO
ALTER DATABASE [DionPrj] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DionPrj] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DionPrj] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DionPrj] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DionPrj] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DionPrj] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DionPrj] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DionPrj] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [DionPrj] SET  MULTI_USER 
GO
ALTER DATABASE [DionPrj] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DionPrj] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DionPrj] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DionPrj] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [DionPrj] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [DionPrj] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [DionPrj] SET QUERY_STORE = ON
GO
ALTER DATABASE [DionPrj] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [DionPrj]
GO
/****** Object:  Table [dbo].[Category_HE161829]    Script Date: 3/24/2023 10:34:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category_HE161829](
	[id] [int] NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[desc] [nvarchar](50) NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order_HE161829]    Script Date: 3/24/2023 10:34:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order_HE161829](
	[clientID] [int] NOT NULL,
	[productID] [int] NOT NULL,
	[dateOrder] [smalldatetime] NOT NULL,
	[quantityOr] [int] NOT NULL,
	[orderID] [int] NOT NULL,
 CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED 
(
	[orderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product_HE161829]    Script Date: 3/24/2023 10:34:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product_HE161829](
	[id] [int] NOT NULL,
	[name] [nvarchar](200) NOT NULL,
	[price] [float] NOT NULL,
	[date] [smalldatetime] NOT NULL,
	[img] [varchar](50) NOT NULL,
	[quantity] [int] NOT NULL,
	[description] [ntext] NULL,
	[cateID] [int] NOT NULL,
	[shopID] [int] NOT NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Shop_HE161829]    Script Date: 3/24/2023 10:34:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Shop_HE161829](
	[shopID] [int] NOT NULL,
	[userID] [int] NULL,
	[review] [nvarchar](200) NULL,
	[vote] [int] NULL,
	[nameShop] [nvarchar](200) NOT NULL,
 CONSTRAINT [PK__Shop__E5C424FC6666B2F2] PRIMARY KEY CLUSTERED 
(
	[shopID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UQ__Shop__CB9A1CDE635E3A1F] UNIQUE NONCLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User_HE161829]    Script Date: 3/24/2023 10:34:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User_HE161829](
	[name] [nvarchar](50) NOT NULL,
	[password] [varchar](16) NOT NULL,
	[userID] [int] NOT NULL,
	[email] [nvarchar](50) NOT NULL,
	[address] [nvarchar](50) NULL,
	[phoneNum] [int] NULL,
	[role] [int] NOT NULL,
	[active] [bit] NOT NULL,
	[gender] [bit] NOT NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Product_HE161829] ADD  CONSTRAINT [DF__Product__sellid__787EE5A0]  DEFAULT ('2') FOR [shopID]
GO
ALTER TABLE [dbo].[Order_HE161829]  WITH CHECK ADD  CONSTRAINT [FK_Order_Product1] FOREIGN KEY([productID])
REFERENCES [dbo].[Product_HE161829] ([id])
GO
ALTER TABLE [dbo].[Order_HE161829] CHECK CONSTRAINT [FK_Order_Product1]
GO
ALTER TABLE [dbo].[Order_HE161829]  WITH CHECK ADD  CONSTRAINT [FK_Order_User] FOREIGN KEY([clientID])
REFERENCES [dbo].[User_HE161829] ([userID])
GO
ALTER TABLE [dbo].[Order_HE161829] CHECK CONSTRAINT [FK_Order_User]
GO
ALTER TABLE [dbo].[Product_HE161829]  WITH CHECK ADD  CONSTRAINT [FK_Product_Category] FOREIGN KEY([cateID])
REFERENCES [dbo].[Category_HE161829] ([id])
GO
ALTER TABLE [dbo].[Product_HE161829] CHECK CONSTRAINT [FK_Product_Category]
GO
ALTER TABLE [dbo].[Product_HE161829]  WITH CHECK ADD  CONSTRAINT [FK_Product_Shop] FOREIGN KEY([shopID])
REFERENCES [dbo].[Shop_HE161829] ([shopID])
GO
ALTER TABLE [dbo].[Product_HE161829] CHECK CONSTRAINT [FK_Product_Shop]
GO
ALTER TABLE [dbo].[Shop_HE161829]  WITH CHECK ADD  CONSTRAINT [OneNguoiOneShop] FOREIGN KEY([userID])
REFERENCES [dbo].[User_HE161829] ([userID])
GO
ALTER TABLE [dbo].[Shop_HE161829] CHECK CONSTRAINT [OneNguoiOneShop]
GO
USE [master]
GO
ALTER DATABASE [DionPrj] SET  READ_WRITE 
GO