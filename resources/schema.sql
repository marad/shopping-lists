
--
-- Table structure for table `items`
--

CREATE TABLE `items` (
  `id` int(11) NOT NULL,
  `date` date NOT NULL,
  `shop` text NOT NULL,
  `ware` text NOT NULL,
  `amount` decimal(7,3) NOT NULL,
  `price` decimal(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`id`, `date`, `shop`, `ware`, `amount`, `price`) VALUES
(1, '2000-01-23', 'Intermarche', 'Mleko', 1.000, 3.00),
(2, '2000-01-11', 'Biedronka', 'Ser', 1.000, 3.00),
(3, '2011-11-20', 'Biedronka', 'Mleko', 1.000, 2.00),
(4, '2011-11-20', 'Intermarche', 'Serek Homogenizowany', 3.000, 1.99);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for table `items`
--
ALTER TABLE `items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
