function strand = reverseComplement(strand)
    strand = upper(strand(end:-1:1));
    maskT = strand == 'T';
    strand(strand == 'A') = 'T';
    strand(maskT) = 'A';
    maskC = strand == 'C';
    strand(strand == 'G') = 'C';
    strand(maskC) = 'G';
    maskW = strand == 'W';
    strand(strand == 'S') = 'W';
    strand(maskW) = 'S';
